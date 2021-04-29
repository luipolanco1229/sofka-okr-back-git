package co.com.sofka.okrs.controller.notificationController;


import co.com.sofka.okrs.domain.User;
import co.com.sofka.okrs.service.notificationService.NotificationConfigurationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController("/notifications")
public class NotificationController {
@Autowired
    NotificationConfigurationService notificationConfigurationService;

    @GetMapping("/{id}")
    public Flux<String> completedOkr(@PathVariable String id){
        return Flux.empty();
    }

    @GetMapping("/idConsultConfig/{id}")
    public Mono<User> ConsultConfig(@PathVariable String id){ return notificationConfigurationService.ConsultConfig(id);}

    @PostMapping("/idInsertConfig")
    public Mono<User> InsertConfig(@RequestBody User user){return Mono.empty(); }

}
