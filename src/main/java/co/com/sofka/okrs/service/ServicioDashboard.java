package co.com.sofka.okrs.service;

import co.com.sofka.okrs.dashboard_dto.UsuarioVista;
import co.com.sofka.okrs.repository.UsuarioRepository;
import co.com.sofka.okrs.utils.Assembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class ServicioDashboard {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Mono<UsuarioVista> usuarioPorId(String id){
        return usuarioRepository.findById(id).map(Assembler::generarUsuarioVista)
                .switchIfEmpty(Mono.error(new IllegalArgumentException("El usuario no se encuentra registrado")));
    }

}
