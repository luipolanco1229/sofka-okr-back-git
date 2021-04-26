package co.com.sofka.okrs.controller;

import co.com.sofka.okrs.domain.User;
import co.com.sofka.okrs.service.UserServiceOKR;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserControllerOKR {
    @Autowired
    private UserServiceOKR userService;

    @PostMapping
    public void save(@RequestBody User user){
        userService.save(user);
    }

}
