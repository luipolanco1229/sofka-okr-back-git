package co.com.sofka.okrs.service;

import co.com.sofka.okrs.domain.Okr;
import co.com.sofka.okrs.repository.RepositoryOKR;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserServiceOKR {
    @Autowired
    private RepositoryOKR repository;

    public Mono<Okr> save(Okr okr){
        return repository.save(okr);
    }


    public Flux<Okr> findAll() {
        return repository.findAll();
    }
}
