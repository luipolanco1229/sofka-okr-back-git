package co.com.sofka.okrs.service;

import co.com.sofka.okrs.dashboard_dto.UsuarioVista;
import co.com.sofka.okrs.repository.UsuarioRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ServicioDashboardTest {

    @InjectMocks
    ServicioDashboard servicioDashboard;

    @Mock
    UsuarioRepository userRepository;

    @Test
    public void usuarioPorId(){

        when(userRepository.findById("xxxx")).thenReturn(TestUtils.usuarioFiltrado());

        StepVerifier.create(servicioDashboard.usuarioPorId("xxxx"))
                .expectNext(new UsuarioVista("Daniel Burgos", "danielburgos@example.com"))
                .verifyComplete();
    }

    @Test
    public void usuarioPorId_ErrorEsperado(){
        when(userRepository.findById("xxxx")).thenReturn(Mono.empty());

        StepVerifier.create(servicioDashboard.usuarioPorId("xxxx"))
                .expectError().verify();
    }


}