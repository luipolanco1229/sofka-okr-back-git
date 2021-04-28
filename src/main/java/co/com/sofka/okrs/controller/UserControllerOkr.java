package co.com.sofka.okrs.controller;

import co.com.sofka.okrs.service.UserServiceOkr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserControllerOkr {
    @Autowired
    private UserServiceOkr userService;



}
