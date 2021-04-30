package co.com.sofka.okrs.controller.notificationController;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class NotificationControllerTest {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void completedOkr(){
         webTestClient.get().uri("/notifications/completedokr".concat("/{id}"),"hfaefhaeth7")
                .exchange()
                .expectStatus().is5xxServerError();
    }

    @Test
    void completedKr(){
        webTestClient.get().uri("/notifications/completedkr".concat("/{id}"),"nsfgnasdh64")
                .exchange()
                .expectStatus().is5xxServerError();

    }


}