package co.com.sofka.okrs.servicePlanification;

import co.com.sofka.okrs.domainPlanification.Okr;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IServiceKr {

    Flux<Okr> findAll();
    Mono<Okr> save();
    Mono<Okr> update();
    Mono<Void> delete(String id);

}
