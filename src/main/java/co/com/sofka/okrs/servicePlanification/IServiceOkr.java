package co.com.sofka.okrs.servicePlanification;

import co.com.sofka.okrs.domainPlanification.Okr;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IServiceOkr {

    Flux<Okr> findAll();
    Mono<Okr> save(Okr okr);
    Mono<Okr> update(Okr okr);
    Mono<Void> delete(String id);
}
