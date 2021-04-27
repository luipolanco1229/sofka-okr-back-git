package co.com.sofka.okrs.service.calendar;

import co.com.sofka.okrs.util.calendar.CalendarUtil;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.util.DateTime;
import com.google.api.services.calendar.Calendar;
import com.google.api.services.calendar.model.Event;
import com.google.api.services.calendar.model.Events;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.security.GeneralSecurityException;

@Service
public class CalendarService {

    public Flux<Event> load() throws GeneralSecurityException, IOException {
        Flux<Event> eventFlux = Flux.fromIterable(
                calendarEvents( new DateTime(System.currentTimeMillis())).getItems()
        ).flatMap(event -> {
                    if(event.isEmpty()) {
                        return Flux.empty();
                    }else {
                        return Mono.just(event);
                    }
                }
        );
        /*eventFlux.subscribe(event -> {
            System.out.println(event.getDescription());
        });*/

        return  eventFlux;
    }

    private Calendar calendarService() throws GeneralSecurityException, IOException {
        // Build a new authorized API client service.
        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
        Calendar calendarService = new Calendar.Builder(HTTP_TRANSPORT, CalendarUtil.JSON_FACTORY, CalendarUtil.getCredentials(HTTP_TRANSPORT))
                .setApplicationName(CalendarUtil.APPLICATION_NAME)
                .build();
        return calendarService;
    }

    private Events calendarEvents(DateTime dateTime) throws GeneralSecurityException, IOException {
        var calendarService = calendarService();
        // List the next 10 events from the primary calendar.
        Events events = calendarService.events().list("primary")
                .setMaxResults(10)
                .setTimeMin(dateTime)
                .setOrderBy("startTime")
                .setSingleEvents(true)
                .execute();

        return events;

    }
}
