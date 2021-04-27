package co.com.sofka.okrs.controller;

import co.com.sofka.okrs.domain.Okr;
import co.com.sofka.okrs.service.UserServiceOKR;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class UserControllerOKR {
    @Autowired
    private UserServiceOKR userService;

    @PostMapping
    public Mono<Okr> save(@RequestBody Okr okr){
        return  userService.save(okr);
    }

    @GetMapping
    public Flux<Okr> findAll() {
        return userService.findAll();
    }

}
