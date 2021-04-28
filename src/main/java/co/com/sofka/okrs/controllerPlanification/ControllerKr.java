package co.com.sofka.okrs.controllerPlanification;

import co.com.sofka.okrs.domainPlanification.Kr;
import co.com.sofka.okrs.servicePlanification.ServiceKr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/Krs")
public class ControllerKr {
    @Autowired
    private ServiceKr serviceKr;

    @PostMapping
    public Mono<Kr> save(@RequestBody Kr kr) {
        return serviceKr.save(kr);
    }

    @GetMapping
    public Flux<Kr> findAll() {
        return serviceKr.findAll();
    }
}
