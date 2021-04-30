package co.com.sofka.okrs.controller.notificationController;


import co.com.sofka.okrs.service.notificationService.NotificationCompletedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/notifications")
@CrossOrigin("*")
public class NotificationController {

    @Autowired
    NotificationCompletedService notificationCompletedService;

    @GetMapping("completedokr/{id}")
    public Mono<List> completedOkr(@PathVariable String id) throws IOException {
        return notificationCompletedService.completedOkr(id);
    }

    @GetMapping("completedkr/{id}")
    public Mono<List> completedKr(@PathVariable String id) throws IOException {
        return notificationCompletedService.completedKr(id);
    }
}
