package co.com.sofka.okrs;

import co.com.sofka.okrs.domain.Okr;
import co.com.sofka.okrs.domain.Usuario;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestUtils {

    public static Mono<Usuario> userFiltered(){
        return Mono.just(new Usuario("xxxx", "Daniel Alejandro", "danielburgos@ejemplo.com"));
    }

    public static Flux<Okr> okrsByUser(){
        List<Okr> okrs = new ArrayList<>();

        Okr okr1 = new Okr("o-xxxxx1",
                "Ganancias Trimestrales",
                "Alcanzar xxx ganancias",
                "Daniel Burgos",
                "danielburgos@example.com",
                "xxxx",
                "Se desea alcanzar unas ganancias de xxx en el trimestre",
                "Desarrollo",
                new Date(),
                new Date(2021, 03, 2),
                0.7f,
                List.of());

        Okr okr2 = new Okr("o-xxxxx2",
                "Desarrollos Trimestriales",
                "Alcanzar xxx desarrollos completados",
                "Daniel Burgos",
                "danielburgos@example.com",
                "xxxx",
                "Se desea completar xxx desarrollos en el trimestre",
                "Desarrollo",
                new Date(),
                new Date(2021, 03, 2),
                0f,
                List.of());

        Okr okr3 = new Okr("o-xxxxx3",
                "Clientes Trimestriales",
                "Alcanzar xxx clientes nuevos",
                "Daniel Burgos",
                "danielburgos@example.com",
                "xxxx",
                "Se desea atraer xxx clientes nuevos",
                "Desarrollo",
                new Date(),
                new Date(2021, 03, 2),
                0.2f,
                List.of());

        okrs.add(okr1);
        okrs.add(okr3);
        okrs.add(okr2);

        return Flux.fromIterable(okrs);
    };


}
