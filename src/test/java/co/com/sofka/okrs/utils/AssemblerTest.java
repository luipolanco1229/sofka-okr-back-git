package co.com.sofka.okrs.utils;

import co.com.sofka.okrs.dashboard_dto.OkrList;
import co.com.sofka.okrs.dashboard_dto.UserView;
import co.com.sofka.okrs.domain.Okr;
import co.com.sofka.okrs.domain.Usuario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;

class AssemblerTest {

    @Test
    void generateUserView(){

        Usuario user = new Usuario("xxxx", "Daniel Alejandro", "danielburgos@example.com");
        UserView userViewExpected = new UserView("Daniel Alejandro", "danielburgos@example.com");

        UserView userViewActual = Assembler.generateUserView(user);

        Assertions.assertEquals(userViewExpected, userViewActual);
    }

    @Test
    void generateUserView_ErrorExpected(){
        Usuario user = new Usuario(null, null, null);

        Assertions.assertThrows(NullPointerException.class, ()-> {
            Assembler.generateUserView(user);
        });
    }

    @Test
    void generateOkrList(){

        Okr okr = new Okr("xxxx",
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
        OkrList okrListExpected = new OkrList("xxxx", "Ganancias Trimestrales", 0.7f);

        OkrList okrListActual = Assembler.generateOkrList(okr);

        Assertions.assertEquals(okrListExpected, okrListActual);
    }

    @Test
    void generarOkrList_ErrorExpected(){
        Okr okr = new Okr(null,
                null,
                "Alcanzar xxx ganancias",
                "Daniel Burgos",
                "danielburgos@example.com",
                "xxxx",
                "Se desea alcanzar unas ganancias de xxx en el trimestre",
                "Desarrollo",
                new Date(),
                new Date(2021, 03, 2),
                null,
                List.of());

        Assertions.assertThrows(NullPointerException.class, () -> {
            Assembler.generateOkrList(okr);
        });
    }

}