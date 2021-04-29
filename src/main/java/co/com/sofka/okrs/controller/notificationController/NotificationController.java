package co.com.sofka.okrs.controller.notificationController;



import co.com.sofka.okrs.domain.User;
import co.com.sofka.okrs.service.notificationService.NotificationCompletedService;
import co.com.sofka.okrs.service.notificationService.NotificationConfigurationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.IOException;

@RestController
@RequestMapping("/notifications")
public class NotificationController {
@Autowired
    NotificationConfigurationService notificationConfigurationService;

    @Autowired
    NotificationCompletedService notificationCompletedService;

    @GetMapping("completedokr/{id}")
    public Flux<String> completedOkr(@PathVariable String id) throws IOException {
        return notificationCompletedService.completedOkr(id);
    }

    @GetMapping("completedkr/{id}")
    public Flux<String> completedKr(@PathVariable String id) throws IOException {
        return notificationCompletedService.completedKr(id);
    }

    @GetMapping("/consultConfig/{id}")
    public Mono<User> ConsultConfig(@PathVariable String id){ return notificationConfigurationService.ConsultConfig(id);}

    @PostMapping("/insertConfig")
    public Mono<User> InsertConfig(@RequestBody User user){return Mono.empty(); }

}
