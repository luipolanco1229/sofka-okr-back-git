package co.com.sofka.okrs.utils;

import co.com.sofka.okrs.dashboard_dto.OkrList;
import co.com.sofka.okrs.dashboard_dto.UserView;
import co.com.sofka.okrs.domain.Okr;
import co.com.sofka.okrs.domain.Usuario;

public class Assembler {

    public static UserView generateUserView(Usuario usuario){
        return new UserView(usuario.getNombre(), usuario.getCorreo());
    }

    public static OkrList generateOkrList(Okr okr){
        return new OkrList(okr.getId(), okr.getTitulo(), okr.getAvanceOkr());
    }
}
