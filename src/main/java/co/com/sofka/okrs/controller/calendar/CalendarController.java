package co.com.sofka.okrs.controller.calendar;
import co.com.sofka.okrs.service.calendar.*;


import com.google.api.services.calendar.model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.security.GeneralSecurityException;

@RestController
@RequestMapping("/calendar")
public class CalendarController {

    @Autowired
    private CalendarService calendarService;

   @PostMapping
    public Mono<EventCalendar> saveEventKR(@RequestBody Evento evento) throws IOException, GeneralSecurityException {
       return calendarService.save(evento);
    }


    @GetMapping("/list")
    public Flux<Event> loadCalendar() throws IOException, GeneralSecurityException {
        return calendarService.load();
    }

}
