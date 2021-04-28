package co.com.sofka.okrs.controller;

import co.com.sofka.okrs.TestUtils;
import co.com.sofka.okrs.dashboard_dto.OkrList;
import co.com.sofka.okrs.repository.RepositoryOKR;
import co.com.sofka.okrs.repository.UsuarioRepository;
import co.com.sofka.okrs.service.DashboardService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@WebFluxTest(controllers = ControladorDashboard.class)
@Import(DashboardService.class)
class ControladorDashboardTest {

    @Autowired
    private WebTestClient webTestClient;

    @MockBean
    private UsuarioRepository usuarioRepository;

    @MockBean
    private RepositoryOKR repositoryOKR;

    @Test
    void userById(){

        when(usuarioRepository.findById("xxxx")).thenReturn(TestUtils.userFiltered());

        webTestClient.get().uri("/dashboard/user/{id}", "xxxx")
                .exchange().expectStatus().isOk().expectBody()
                .jsonPath("$.name").isNotEmpty()
                .jsonPath("$.name").isEqualTo("Daniel Alejandro")
                .jsonPath("$.email").isNotEmpty()
                .jsonPath("$.email").isEqualTo("danielburgos@ejemplo.com");

        Mockito.verify(usuarioRepository, times(1)).findById("xxxx");
    }

    @Test
    void userById_NoIdOnDataBase(){

        when(usuarioRepository.findById("xxxx")).thenReturn(Mono.empty());

        webTestClient.get().uri("/dashboard/user/{id}", "xxxx")
                .exchange().expectStatus().isEqualTo(404);
    }

    @Test
    void userById_NullId(){
        webTestClient.get().uri("/dashboard/user/{id}", (Object) null)
                .exchange().expectStatus().isEqualTo(404);
    }


    @Test
    void okrByUser(){

        when(repositoryOKR.findByUsuarioIdOrderByAvanceOkrDesc("xxxx")).thenReturn(TestUtils.okrsByUser());

        Flux<OkrList> okrListaFlux =  webTestClient.get().uri("/dashboard/user-okrs/{id}", "xxxx")
                .header(HttpHeaders.ACCEPT, "application/json")
                .exchange()
                .expectStatus().isOk().returnResult(OkrList.class).getResponseBody();

        StepVerifier.create(okrListaFlux).expectNextCount(3).verifyComplete();

        Mockito.verify(repositoryOKR, times(1)).findByUsuarioIdOrderByAvanceOkrDesc("xxxx");
    }

    @Test
    void okrByUser_NullId(){
        webTestClient.get().uri("/dashboard/user-okrs/{id}", (Object) null)
                .exchange().expectStatus().isEqualTo(404);
    }

    @Test
    void okrByUser_NoIdInDataBase(){
        when(repositoryOKR.findByUsuarioIdOrderByAvanceOkrDesc("xxxx")).thenReturn(Flux.empty());

        webTestClient.get().uri("/dashboard/user-okrs/{id}", "xxxx")
                .exchange().expectStatus().isEqualTo(404);
    }

    @Test
    void nullPointerException_controlled(){
        when(repositoryOKR.findByUsuarioIdOrderByAvanceOkrDesc("xxxx")).thenThrow(new NullPointerException());

        webTestClient.get().uri("/dashboard/user-okrs/{id}", "xxxx")
                .exchange().expectStatus().isEqualTo(400);
    }

    @Test
    void illegalArgumentException_controlled(){
        when(repositoryOKR.findByUsuarioIdOrderByAvanceOkrDesc("xxxx")).thenThrow(new IllegalArgumentException());

        webTestClient.get().uri("/dashboard/user-okrs/{id}", "xxxx")
                .exchange().expectStatus().isEqualTo(404);
    }

}