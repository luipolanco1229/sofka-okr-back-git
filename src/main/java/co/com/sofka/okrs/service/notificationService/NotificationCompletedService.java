package co.com.sofka.okrs.service.notificationService;

import co.com.sofka.okrs.domain.Okr;
import co.com.sofka.okrs.domain.User;
import co.com.sofka.okrs.repository.RepositoryOkr;
import co.com.sofka.okrs.repository.UserRepository;
import co.com.sofka.okrs.utils.notificationsUtils.emailsNotifications.EmailCompletedOkr;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class NotificationCompletedService {


    @Autowired
    UserRepository userRepository;
    @Autowired
    RepositoryOkr repositoryOkr;


    public Flux<String> completedOkr(String id) throws IOException {
        List<String> dataCompletedOkr = new ArrayList<>();
        Mono<Okr> documentOkr = repositoryOkr.findById(id);
        documentOkr.map(okr -> {dataCompletedOkr.add(okr.getUserId()); dataCompletedOkr.add(okr.getTitle()); dataCompletedOkr.add(okr.getAdvanceOkr().toString());
        return  okr;});
        Mono<User> documentUser = userRepository.findById(dataCompletedOkr.get(0));
        documentUser.map(user -> {dataCompletedOkr.add(user.getEmail()); dataCompletedOkr.add(user.getName());
        return user;});

        if (Float.parseFloat(dataCompletedOkr.get(2)) == 100){
            completedOkrEmail(dataCompletedOkr.get(3));
            return Flux.just(dataCompletedOkr.get(1), dataCompletedOkr.get(4));
        } return Flux.empty();

    }









    private void completedOkrEmail(String email) throws IOException {
        Email from = new Email("Sofka.OKR@gmail.com");
        Email to = new Email(email);
        String subject = "Haz completado un OKR";
        Content content = new Content("text/html", EmailCompletedOkr.emailHtmlCompletedOkr());
        Mail mail = new Mail(from, subject, to, content);

        SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
        Request request = new Request();

        try{
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sg.api(request);
            System.out.println(response.getStatusCode());
            System.out.println(response.getBody());
            System.out.println(response.getHeaders());
        } catch (IOException ex){
            throw ex;
        }
    }
}



