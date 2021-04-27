package co.com.sofka.okrs.utils;

import co.com.sofka.okrs.dashboard_dto.UsuarioVista;
import co.com.sofka.okrs.domain.Usuario;

public class Assembler {

    public static UsuarioVista generarUsuarioVista(Usuario usuario){
        return new UsuarioVista(usuario.getNombre(), usuario.getCorreo());
    }
}
