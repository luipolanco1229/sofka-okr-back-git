package co.com.sofka.okrs.servicePlanification;

import co.com.sofka.okrs.domainPlanification.Kr;
import co.com.sofka.okrs.domainPlanification.Okr;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IServiceKr {

    Flux<Kr> findAll();
    Mono<Kr> save(Kr kr);
    Mono<Void> delete(String id);

}
