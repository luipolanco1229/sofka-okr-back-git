package co.com.sofka.okrs.controller;

import co.com.sofka.okrs.TestUtils;
import co.com.sofka.okrs.dashboard_dto.OkrList;
import co.com.sofka.okrs.repository.RepositoryKr;
import co.com.sofka.okrs.repository.RepositoryOkr;
import co.com.sofka.okrs.repository.UserRepository;
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
    private UserRepository userRepository;

    @MockBean
    private RepositoryOkr repositoryOKR;

    @MockBean
    private RepositoryKr repositoryKr;

    @Test
    void userById(){

        when(userRepository.findById("xxxx")).thenReturn(TestUtils.userFiltered());

        webTestClient.get().uri("/dashboard/user/{id}", "xxxx")
                .exchange().expectStatus().isOk().expectBody()
                .jsonPath("$.name").isNotEmpty()
                .jsonPath("$.name").isEqualTo("Daniel Alejandro")
                .jsonPath("$.email").isNotEmpty()
                .jsonPath("$.email").isEqualTo("danielburgos@ejemplo.com");

        Mockito.verify(userRepository, times(1)).findById("xxxx");
    }

    @Test
    void userById_NoIdOnDataBase(){

        when(userRepository.findById("xxxx")).thenReturn(Mono.empty());

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
    void findOkrTablebyId(){
        when(repositoryOKR.findById("6084801fb2ce1e4174af0245")).thenReturn(TestUtils.getMonoOkr());

        when(repositoryKr.findByOkrId("6084801fb2ce1e4174af0245")).thenReturn(Flux.fromIterable(TestUtils.getListaKr()));

        webTestClient.get().uri("/dashboard/okrTable/{id}", "6084801fb2ce1e4174af0245")
                .exchange().expectStatus().isOk().expectBody()
                .jsonPath("$.title").isNotEmpty()
                .jsonPath("$.title").isEqualTo("xxxxxx")
                .jsonPath("$.personInChargeNameOkr").isNotEmpty()
                .jsonPath("$.personInChargeNameOkr").isEqualTo("danielBurgos");
    }
    @Test
    void findOkrTablebyIdWithNotFoundId(){
        when(repositoryOKR.findById("xxxx")).thenReturn(Mono.empty());
        when(repositoryKr.findByOkrId("xxxx")).thenReturn(Flux.empty());

        webTestClient.get().uri("/dashboard/okrTable/{id}", "xxxx")
                .exchange().expectStatus().isEqualTo(200);
    }

    @Test
    public void findAdvanceOkrByOkrId(){
        when(repositoryOKR.findById("6084801fb2ce1e4174af0245")).thenReturn(TestUtils.getMonoOkr());

        webTestClient.get().uri("/dashboard/okrAdvance/{id}", "6084801fb2ce1e4174af0245")
                .exchange().expectStatus().isOk().expectBody()
                .equals(0.68f);

        Mockito.verify(repositoryOKR, times(1)).findById("6084801fb2ce1e4174af0245");
    }

    @Test
    public void findAdvanceOkrByOkrIdWithNotFoundOId(){
        when(repositoryOKR.findById("xxxx")).thenReturn(Mono.empty());

        webTestClient.get().uri("/dashboard/okrAdvance/{id}", "xxxx")
                .exchange().expectStatus().isEqualTo(200);
    }
}