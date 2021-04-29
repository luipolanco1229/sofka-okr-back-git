package co.com.sofka.okrs.controller.notificationController;

import co.com.sofka.okrs.service.notificationService.NotificationAdvancedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.io.IOException;

@RestController
@RequestMapping("/bell")
public class BellNotificationController {
    @Autowired
    NotificationAdvancedService notificationAdvancedService;

    @GetMapping("advancedokr/{id}")
    public Flux<String> advancedOkr(@PathVariable String id) throws IOException {
        return notificationAdvancedService.advancedOkrService(id);
    }
    @GetMapping("advancedkr/{id}")
    public Flux<String> advancedKr(@PathVariable String id) throws IOException {
        return notificationAdvancedService.advancedKrService(id);
    }
}
