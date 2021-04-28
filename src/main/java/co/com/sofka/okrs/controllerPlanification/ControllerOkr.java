package co.com.sofka.okrs.controllerPlanification;

import co.com.sofka.okrs.domainPlanification.Okr;
import co.com.sofka.okrs.servicePlanification.ServiceOkr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/Okrs")
public class ControllerOkr {
    @Autowired
    private ServiceOkr userService;

    @GetMapping
    public Flux<Okr> findAll() {
        return userService.findAll();
    }

    @PostMapping("/postOkr")
    public Mono<Okr> save(@RequestBody Okr okr){
        return  userService.save(okr);
    }

    @PutMapping("/updOkr")
    public Mono<Okr> update(@RequestBody Okr okr){
        return  userService.save(okr);
    }

    @DeleteMapping("/deleteOkr/{id}")
    public Mono<Void> delete(@PathVariable("id") String id){
        return  userService.delete(id);
    }

    }


