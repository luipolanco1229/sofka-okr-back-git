package co.com.sofka.okrs.service.notificationService;

import co.com.sofka.okrs.domain.Kr;
import co.com.sofka.okrs.domain.Okr;
import co.com.sofka.okrs.domain.notificationsDomain.Notification;
import co.com.sofka.okrs.repository.RepositoryKr;
import co.com.sofka.okrs.repository.RepositoryOkr;
import co.com.sofka.okrs.utils.dashboardUtils.Assembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class NotificationAdvancedService {
    @Autowired
    private RepositoryOkr okrRepository;

    @Autowired
    private RepositoryKr krRepository;

    public Flux<String> advancedOkrService(String id) throws IOException {

        List<String> dataAdvancedOkr = new ArrayList<>();
        Flux<Okr> documentOkr = okrRepository.findAll().filter(okr -> okr.getUserId().equals(id));
        documentOkr.map(okr -> {dataAdvancedOkr.add(okr.getUserId()); dataAdvancedOkr.add(okr.getTitle()); dataAdvancedOkr.add(okr.getAdvanceOkr().toString());
        return  okr;});


        //Notification notification = new Notification(id,dataAdvancedOkr.get(2),);

        //30% -> idnoti  -> false
        //70% -> idnoti  -> false

        //bell -> put -> true

        if (Float.parseFloat(dataAdvancedOkr.get(2)) < 100 ){
            return Flux.just(dataAdvancedOkr.get(1));
        }
        return Flux.empty();
    }

    public Flux<String> advancedKrService(String id) throws IOException {
        List<String> dataAdvancedKr = new ArrayList<>();
        Flux<Kr> documentKr = krRepository.findAll();
        documentKr.map(kr -> {dataAdvancedKr.add(kr.getOkrId()); dataAdvancedKr.add(kr.getDescriptionKr()); dataAdvancedKr.add(kr.getAdvanceKr().toString());
            return  kr;});
        /*Mono<User> documentUser = userRepository.findById(dataAdvancedOkr.get(0));
        documentUser.map(user -> {dataAdvancedOkr.add(user.getEmail()); dataAdvancedOkr.add(user.getName());
        return user;});*/

        if (Float.parseFloat(dataAdvancedKr.get(2)) >= 100){
            return Flux.just(dataAdvancedKr.get(1), dataAdvancedKr.get(4));
        } return Flux.empty();
    }
}
