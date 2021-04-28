package co.com.sofka.okrs.controller.calendarcontroller;

import co.com.sofka.okrs.domain.calendarDomain.EventCalendar;
import co.com.sofka.okrs.service.calendarservice.CalendarService;
import com.google.api.services.calendar.model.Event;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.security.GeneralSecurityException;


@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext
@AutoConfigureWebTestClient
@ActiveProfiles("test")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CalendarControllerTest {

    @Autowired
    private WebTestClient webTestClient;

    @MockBean
    CalendarService calendarService;

    @Test
    void loadCalendar() throws GeneralSecurityException, IOException {
        Mockito.when(calendarService.load()).thenReturn(Flux.just(new Event()));

        Flux<Event> calFlux = webTestClient.get().uri("/calendar/list").exchange()
                .expectStatus().isOk()
                .returnResult(Event.class)
                .getResponseBody();
    }
    @Test
    void saveCalendar() throws GeneralSecurityException, IOException {
        Mockito.when(calendarService.save(EventCalendar.DEFAULT_EVENT_CALENDAR)).thenReturn(Mono.just(new Event()));
        webTestClient.post().uri("/calendar/save").contentType(MediaType.valueOf(MediaType.APPLICATION_JSON_VALUE))
                .body(Mono.just(EventCalendar.DEFAULT_EVENT_CALENDAR), EventCalendar.class)
                .exchange()
                .expectStatus().isOk();

    }

}