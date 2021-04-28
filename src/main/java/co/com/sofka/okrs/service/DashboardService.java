package co.com.sofka.okrs.service;

import co.com.sofka.okrs.dashboard_dto.OkrList;
import co.com.sofka.okrs.dashboard_dto.UserView;
import co.com.sofka.okrs.repository.RepositoryOKR;
import co.com.sofka.okrs.repository.UsuarioRepository;
import co.com.sofka.okrs.utils.Assembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Objects;

@Service
public class DashboardService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RepositoryOKR repositoryOKR;

    public Mono<UserView> userById(String id){
        return usuarioRepository.findById(Objects.requireNonNull(id)).map(Assembler::generateUserView)
                .switchIfEmpty(Mono.error(new IllegalArgumentException("User not found")));
    }

    public Flux<OkrList> okrByUser(String id){
        return repositoryOKR.findByUsuarioIdOrderByAvanceOkrDesc(Objects.requireNonNull(id)).map(Assembler::generateOkrList)
                .switchIfEmpty(Mono.error(new IllegalArgumentException("There are not OKRs related with that User")));
    }
}
