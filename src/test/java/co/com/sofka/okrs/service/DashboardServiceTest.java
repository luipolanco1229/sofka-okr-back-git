package co.com.sofka.okrs.service;

import co.com.sofka.okrs.TestUtils;
import co.com.sofka.okrs.dashboard_dto.OkrLista;
import co.com.sofka.okrs.dashboard_dto.UsuarioVista;
import co.com.sofka.okrs.repository.RepositoryOKR;
import co.com.sofka.okrs.repository.UsuarioRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ServicioDashboardTest {

    @InjectMocks
    ServicioDashboard servicioDashboard;

    @Mock
    UsuarioRepository userRepository;

    @Mock
    RepositoryOKR repositoryOKR;

    @Test
    void usuarioPorId(){

        when(userRepository.findById("xxxx")).thenReturn(TestUtils.usuarioFiltrado());

        StepVerifier.create(servicioDashboard.usuarioPorId("xxxx"))
                .expectNext(new UsuarioVista("Daniel Alejandro", "danielburgos@ejemplo.com"))
                .verifyComplete();
    }

    @Test
    void usuarioPorId_ErrorEsperado(){

        when(userRepository.findById("xxxx")).thenReturn(Mono.empty());

        StepVerifier.create(servicioDashboard.usuarioPorId("xxxx"))
                .expectError().verify();
    }

    @Test
    void okrPorUsuario(){

        when(repositoryOKR.findByUsuarioIdOrderByAvanceOkrDesc("xxxx")).thenReturn(TestUtils.okrsPorUsuario());

        StepVerifier.create(servicioDashboard.okrPorUsuario("xxxx"))
                .expectNext(new OkrLista("o-xxxxx1", "Ganancias Trimestrales", 0.7f))
                .expectNext(new OkrLista("o-xxxxx3", "Clientes Trimestriales", 0.2f))
                .expectNext(new OkrLista("o-xxxxx2", "Desarrollos Trimestriales", 0f))
                .verifyComplete();
    }

    @Test
    void okrPorUsuario_ErrorEsperado(){

        when(repositoryOKR.findByUsuarioIdOrderByAvanceOkrDesc("xxxx")).thenReturn(Flux.empty());

        StepVerifier.create(servicioDashboard.okrPorUsuario("xxxx"))
                .expectError().verify();
    }



}