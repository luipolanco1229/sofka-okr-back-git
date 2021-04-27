package co.com.sofka.okrs.service;

import co.com.sofka.okrs.domain.Usuario;
import reactor.core.publisher.Mono;

public class TestUtils {

    public static Mono<Usuario> usuarioFiltrado(){
        return Mono.just(new Usuario("xxxx", "Daniel Burgos", "danielburgos@example.com"));
    }
}
