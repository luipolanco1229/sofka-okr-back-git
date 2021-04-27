package co.com.sofka.okrs.controller;

import co.com.sofka.okrs.domain.Kr;
import co.com.sofka.okrs.service.ServiceKr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/Kr")
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
