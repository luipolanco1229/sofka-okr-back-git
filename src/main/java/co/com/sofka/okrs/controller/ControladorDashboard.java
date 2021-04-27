package co.com.sofka.okrs.controller;

import co.com.sofka.okrs.dashboard_dto.UsuarioVista;
import co.com.sofka.okrs.service.ServicioDashboard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.Objects;

@RestController
@CrossOrigin(origins = "https://sofka-okr-front.web.app/")
public class ControladorDashboard {
    @Autowired
    private ServicioDashboard servicioDashboard;


    @GetMapping(value = "dasboard/usuario/{id}")
    public Mono<UsuarioVista> usuarioPorId(@PathVariable("id") String id){
        return servicioDashboard.usuarioPorId(Objects.requireNonNull(id));
    }

}
