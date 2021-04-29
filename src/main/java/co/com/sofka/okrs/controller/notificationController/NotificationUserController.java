package co.com.sofka.okrs.controller.notificationController;

import co.com.sofka.okrs.dto.dashboard_dto.UserView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import co.com.sofka.okrs.service.notificationService.NotificationUserEmailService;
import reactor.core.publisher.Mono;

import java.util.Objects;

@RestController
@CrossOrigin(origins = "https://sofka-okr-front.web.app/")
public class NotificationUserController {
    @Autowired
    private NotificationUserEmailService notificationUserEmailService;


    @GetMapping(value = "dashboard/user/{id}")
    public Mono<UserView> userById(@PathVariable("id") String id){
        return notificationUserEmailService.userByIdAndEmail(Objects.requireNonNull(id));
    }
}
