package co.com.sofka.okrs.controller.notificationController;


import co.com.sofka.okrs.service.notificationService.NotificationCompletedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.IOException;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

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
}
