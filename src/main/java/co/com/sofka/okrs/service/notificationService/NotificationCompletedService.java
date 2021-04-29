package co.com.sofka.okrs.service.notificationService;

import co.com.sofka.okrs.domain.Kr;
import co.com.sofka.okrs.domain.Okr;
import co.com.sofka.okrs.domain.User;
import co.com.sofka.okrs.domain.notificationsDomain.Notification;
import co.com.sofka.okrs.repository.RepositoryKr;
import co.com.sofka.okrs.repository.RepositoryNotification;
import co.com.sofka.okrs.repository.RepositoryOkr;
import co.com.sofka.okrs.repository.UserRepository;
import co.com.sofka.okrs.utils.notificationsUtils.emailsNotifications.EmailCompletedKr;
import co.com.sofka.okrs.utils.notificationsUtils.emailsNotifications.EmailCompletedOkr;
import com.sendgrid.*;
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
    @Autowired
    RepositoryNotification repositoryNotification;
    Notification notification = new Notification();
    @Autowired
    RepositoryKr repositoryKr;
    @Autowired
    SendGridAPI sendGridAPI;


    public Flux<String> completedOkr(String id) throws IOException {
        List<String> dataCompletedOkr = new ArrayList<>();
        /*Mono<Okr> documentOkr = repositoryOkr.findById(id);
        documentOkr.map(okr -> {dataCompletedOkr.add(okr.getUserId());
                                dataCompletedOkr.add(okr.getTitle());
                                dataCompletedOkr.add(okr.getAdvanceOkr().toString());
        return  okr;});
        Mono<User> documentUser = userRepository.findById(dataCompletedOkr.get(0));
        documentUser.map(user -> {dataCompletedOkr.add(user.getEmail());
                                    dataCompletedOkr.add(user.getName());
                                    dataCompletedOkr.add(user.getNotificationCompletedKr().toString());
                                    dataCompletedOkr.add(user.getMailCompletedKr().toString());
        return user;});*/
       dataCompletedOkr.add("fjhvc4445nfd6h4nfd4");
        dataCompletedOkr.add("Crear tarea");
        Float numero = 100F;
        dataCompletedOkr.add(numero.toString());
        dataCompletedOkr.add("luipolanco1229@gmail.com");
        dataCompletedOkr.add("Luisa");
        Boolean boolean1= true;
        dataCompletedOkr.add(boolean1.toString());
        Boolean boolean2= true;
        dataCompletedOkr.add(boolean2.toString());


        return sendNotificationCompletedOkr(dataCompletedOkr);

    }

    private Flux<String> sendNotificationCompletedOkr(List<String> dataCompletedOkr) throws IOException {
        if (Float.parseFloat(dataCompletedOkr.get(2)) == 100 && Boolean.parseBoolean(dataCompletedOkr.get(5)) == true && Boolean.parseBoolean(dataCompletedOkr.get(6)) == true){
            completedOkrEmail(dataCompletedOkr.get(3), dataCompletedOkr.get(4), dataCompletedOkr.get(1));
            notification.setNotificationDescription("Haz completado el OKR" + dataCompletedOkr.get(1));
            notification.setViewed(false);
            repositoryNotification.save(new Notification("", dataCompletedOkr.get(0), notification.getNotificationDescription(),
                    dataCompletedOkr.get(1),  notification.getViewed()));
            return Flux.just(dataCompletedOkr.get(1), dataCompletedOkr.get(4));
        }
        return Flux.empty();
    }


    public Flux<String> completedKr(String id) throws IOException {
        List<String> dataCompletedKr = new ArrayList<>();
        /*Mono<Kr> documentKr = repositoryKr.findById(id);
        documentKr.map(kr -> {dataCompletedKr.add(kr.getId());
                                dataCompletedKr.add(kr.getKeyResult());
                                dataCompletedKr.add(kr.getOkrId());
                                dataCompletedKr.add(kr.getAdvanceKr().toString());
        return  kr;});
        Mono<Okr> documentOkr = repositoryOkr.findById(dataCompletedKr.get(2));
        documentOkr.map(okr -> {dataCompletedKr.add(okr.getUserId()); return okr; });
        Mono<User> documentUser = userRepository.findById(dataCompletedKr.get(0));
        documentUser.map(user -> {dataCompletedKr.add(user.getEmail());
                                    dataCompletedKr.add(user.getName());
                                    dataCompletedKr.add(user.getNotificationCompletedKr().toString());
                                    dataCompletedKr.add(user.getMailCompletedKr().toString());
        return user;});*/
        dataCompletedKr.add("fjhvc4445nfd6h4nfd4");
        dataCompletedKr.add("Crear  tarea sobre ¿que mas?");
        dataCompletedKr.add("fjhvc4445nfnsdgsanfd4");
        Float numero = 100F;
        dataCompletedKr.add(numero.toString());
        dataCompletedKr.add("hjsr45nfd6h4nfd4");
        dataCompletedKr.add("luipolanco1229@gmail.com");
        dataCompletedKr.add("Luisa");
        Boolean boolean1= false;
        dataCompletedKr.add(boolean1.toString());
        Boolean boolean2= false;
        dataCompletedKr.add(boolean2.toString());


        return sendNotificationCompletedKr(dataCompletedKr);

    }







    private Flux<String> sendNotificationCompletedKr(List<String> dataCompletedKr) throws IOException {
        if (Float.parseFloat(dataCompletedKr.get(3)) == 100 && Boolean.parseBoolean(dataCompletedKr.get(7)) == true && Boolean.parseBoolean(dataCompletedKr.get(8)) == true){
            completedKrEmail(dataCompletedKr.get(5), dataCompletedKr.get(6), dataCompletedKr.get(1));
            notification.setNotificationDescription("Haz completado este KR" + dataCompletedKr.get(1));
            notification.setViewed(false);
            repositoryNotification.save(new Notification("", dataCompletedKr.get(4), notification.getNotificationDescription(),
                    dataCompletedKr.get(2), dataCompletedKr.get(1),  notification.getViewed() ));
            return Flux.just(dataCompletedKr.get(1), dataCompletedKr.get(4));
        }
        return Flux.empty();
    }


    private void completedOkrEmail(String email,  String name, String title) throws IOException {
        Email from = new Email("Sofka.OKR@gmail.com");
        Email to = new Email(email);
        String subject = "Haz completado un OKR";
        Content content = new Content("text/html", EmailCompletedOkr.emailHtmlCompletedOkr(name, title));
        Mail mail = new Mail(from, subject, to, content);
        Request request = new Request();

        try{
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sendGridAPI.api(request);
            System.out.println(response.getStatusCode());
            System.out.println(response.getBody());
            System.out.println(response.getHeaders());
        } catch (IOException ex){
            throw ex;
        }
    }

    private void completedKrEmail(String email, String name, String title) throws IOException {
        Email from = new Email("Sofka.OKR@gmail.com");
        Email to = new Email(email);
        String subject = "Haz completado un KR";
        Content content = new Content("text/html", EmailCompletedKr.emailHtmlCompletedKr());
        Mail mail = new Mail(from, subject, to, content);
        Request request = new Request();

        try{
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sendGridAPI.api(request);
            System.out.println(response.getStatusCode());
            System.out.println(response.getBody());
            System.out.println(response.getHeaders());
        } catch (IOException ex){
            throw ex;
        }
    }
}



