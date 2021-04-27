package co.com.sofka.okrs.dashboard_dto;

import java.util.Objects;

public class UsuarioVista {

    private String nombre;
    private String correo;

    public UsuarioVista(String nombre, String correo){
        this.nombre = Objects.requireNonNull(nombre);
        this.correo = Objects.requireNonNull(correo);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsuarioVista that = (UsuarioVista) o;
        return Objects.equals(nombre, that.nombre) && Objects.equals(correo, that.correo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, correo);
    }
}
