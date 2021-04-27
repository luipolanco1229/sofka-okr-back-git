package co.com.sofka.okrs.controller;

import co.com.sofka.okrs.domain.Okr;
import co.com.sofka.okrs.service.ServiceOkr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/Okr")
public class ControllerOkr {
    @Autowired
    private ServiceOkr userService;

    @PostMapping
    public Mono<Okr> save(@RequestBody Okr okr){
        return  userService.save(okr);
    }

    @GetMapping
    public Flux<Okr> findAll() {
        return userService.findAll();
    }

}
