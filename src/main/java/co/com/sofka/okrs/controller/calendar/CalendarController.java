package co.com.sofka.okrs.controller.calendar;
import co.com.sofka.okrs.domain.calendarDomain.EventCalendar;
import co.com.sofka.okrs.service.calendar.*;


import com.google.api.services.calendar.model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @PostMapping("/save")
    public Mono<Event> saveEventKR(@RequestBody EventCalendar eventCalendar) throws IOException, GeneralSecurityException {
       return calendarService.save(eventCalendar);
    }


    @GetMapping("/list")
    @ResponseStatus(HttpStatus.OK)
    public Flux<Event> loadCalendar() throws IOException, GeneralSecurityException {
        return calendarService.load();
    }

}
