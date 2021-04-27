package co.com.sofka.okrs.controller;

import co.com.sofka.okrs.dashboard_dto.UsuarioVista;
import co.com.sofka.okrs.domain.Usuario;
import co.com.sofka.okrs.repository.UsuarioRepository;
import co.com.sofka.okrs.service.ServicioDashboard;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.AutoConfigureWebClient;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@WebFluxTest(controllers = ControladorDashboard.class)
@Import(ServicioDashboard.class)
class ControladorDashboardTest {

    @Autowired
    private WebTestClient webTestClient;

    @MockBean
    private UsuarioRepository usuarioRepository;

    @Test
    void usuarioPorId(){

        Usuario usuario = new Usuario("xxxx", "Daniel Alejandro", "danielburgos@ejemplo.com");

        when(usuarioRepository.findById("xxxx")).thenReturn(Mono.just(usuario));

        webTestClient.get().uri("/dasboard/usuario/{id}", "xxxx")
                .exchange().expectStatus().isOk().expectBody()
                .jsonPath("$.nombre").isNotEmpty()
                .jsonPath("$.nombre").isEqualTo("Daniel Alejandro")
                .jsonPath("$.correo").isNotEmpty()
                .jsonPath("$.correo").isEqualTo("danielburgos@ejemplo.com");

        Mockito.verify(usuarioRepository, times(1)).findById("xxxx");
    }

    @Test
    void usuarioPorId_NoIdPresente(){

        when(usuarioRepository.findById("xxxx")).thenReturn(Mono.empty());

        webTestClient.get().uri("/dashboard/usuario/{id}", "xxxx")
                .exchange().expectStatus().isEqualTo(404);
    }

}