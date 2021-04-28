package co.com.sofka.okrs.controller;

import co.com.sofka.okrs.domain.User;
import co.com.sofka.okrs.service.UserServiceOKR;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "api/", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*")
public class UserControllerOKR {
    @Autowired
    private UserServiceOKR userService;

    @PostMapping("/users")
    public Mono<User> save(@RequestBody User user){
        return  userService.save(user);
    }

}
