package co.com.sofka.okrs.service;

import co.com.sofka.okrs.TestUtils;
import co.com.sofka.okrs.dashboard_dto.OkrList;
import co.com.sofka.okrs.dashboard_dto.UserView;
import co.com.sofka.okrs.repository.RepositoryOKR;
import co.com.sofka.okrs.repository.UsuarioRepository;
import org.junit.jupiter.api.Assertions;
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
class DashboardServiceTest {

    @InjectMocks
    DashboardService dashboardService;

    @Mock
    UsuarioRepository userRepository;

    @Mock
    RepositoryOKR repositoryOKR;

    @Test
    void userById(){

        when(userRepository.findById("xxxx")).thenReturn(TestUtils.userFiltered());

        StepVerifier.create(dashboardService.userById("xxxx"))
                .expectNext(new UserView("Daniel Alejandro", "danielburgos@ejemplo.com"))
                .verifyComplete();
    }

    @Test
    void userById_ErrorExpected(){

        when(userRepository.findById("xxxx")).thenReturn(Mono.empty());

        StepVerifier.create(dashboardService.userById("xxxx"))
                .expectError().verify();
    }

    @Test
    void userById_NullPointerExceptionExpected(){
        Assertions.assertThrows(NullPointerException.class, ()-> {
            dashboardService.userById(null);
        });
    }

    @Test
    void okrByUser(){

        when(repositoryOKR.findByUsuarioIdOrderByAvanceOkrDesc("xxxx")).thenReturn(TestUtils.okrsByUser());

        StepVerifier.create(dashboardService.okrByUser("xxxx"))
                .expectNext(new OkrList("o-xxxxx1", "Ganancias Trimestrales", 0.7f))
                .expectNext(new OkrList("o-xxxxx3", "Clientes Trimestriales", 0.2f))
                .expectNext(new OkrList("o-xxxxx2", "Desarrollos Trimestriales", 0f))
                .verifyComplete();
    }

    @Test
    void okrByUser_ErrorExpected(){

        when(repositoryOKR.findByUsuarioIdOrderByAvanceOkrDesc("xxxx")).thenReturn(Flux.empty());

        StepVerifier.create(dashboardService.okrByUser("xxxx"))
                .expectError().verify();
    }

    @Test
    void okrByUser_NullPointerExceptionExpected(){
        Assertions.assertThrows(NullPointerException.class, ()-> {
            dashboardService.okrByUser(null);
        });
    }


}