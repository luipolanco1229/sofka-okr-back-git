package co.com.sofka.okrs.service;

import co.com.sofka.okrs.domain.Okr;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IServiceKr {

    Flux<Okr> findAll();
    Mono<Okr> save();
    Mono<Okr> update();
    Mono<Void> delete(String id);

}
