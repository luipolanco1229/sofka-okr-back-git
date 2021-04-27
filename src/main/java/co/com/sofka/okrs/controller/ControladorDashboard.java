package co.com.sofka.okrs.controller;

import co.com.sofka.okrs.service.ServicioDashboard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "https://sofka-okr-front.web.app/")
public class ControladorDashboard {
    @Autowired
    private ServicioDashboard servicioDashboard;


}
