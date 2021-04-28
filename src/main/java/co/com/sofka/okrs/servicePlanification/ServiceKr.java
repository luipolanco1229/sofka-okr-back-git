package co.com.sofka.okrs.servicePlanification;

import co.com.sofka.okrs.domainPlanification.Kr;
import co.com.sofka.okrs.repositoryPlanification.RepositoryKr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ServiceKr {

    @Autowired
    private RepositoryKr repositoryKr;

    public Mono<Kr> save(Kr kr) {
        return repositoryKr.save(kr);
    }

    public Flux<Kr> findAll() {
        return repositoryKr.findAll();
    }
}
