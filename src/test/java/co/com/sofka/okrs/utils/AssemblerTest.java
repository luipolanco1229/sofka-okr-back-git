package co.com.sofka.okrs.utils;

import co.com.sofka.okrs.dashboard_dto.UsuarioVista;
import co.com.sofka.okrs.domain.Usuario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AssemblerTest {

    @Test
    public void generarUsuarioVista(){

        Usuario usuario = new Usuario("xxxx", "Daniel Alejandro", "danielburgos@example.com");
        UsuarioVista usuarioVistaEsperado = new UsuarioVista("Daniel Alejandro", "danielburgos@example.com");

        UsuarioVista usuarioVistaActual = Assembler.generarUsuarioVista(usuario);

        Assertions.assertEquals(usuarioVistaActual, usuarioVistaEsperado);
    }

    @Test
    public void generarUsuarioVista_ErrorEsperado(){
        Usuario usuario = new Usuario(null, null, null);

        Assertions.assertThrows(NullPointerException.class, ()-> {
            Assembler.generarUsuarioVista(usuario);
        });
    }

}