package co.com.sofka.okrs.service;

import co.com.sofka.okrs.domain.Okr;
import co.com.sofka.okrs.repository.RepositoryOkr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ServiceOkr {
    @Autowired
    private RepositoryOkr repositoryOKr;

    public Mono<Okr> save(Okr okr){
        return repositoryOKr.save(okr);
    }

    public Flux<Okr> findAll() {
        return repositoryOKr.findAll();
    }
}
