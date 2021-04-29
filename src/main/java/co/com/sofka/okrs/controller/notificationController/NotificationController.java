package co.com.sofka.okrs.controller.notificationController;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController("/notifications")
public class NotificationController {

    @GetMapping("/{id}")
    public Flux<String> completedOkr(@PathVariable String id){

    }
}
