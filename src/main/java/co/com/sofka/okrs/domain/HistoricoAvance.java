package co.com.sofka.okrs.domain;

import java.util.Date;

public class HistoricoAvance {

    private Date fechaActualizacion;
    private Float nuevoAvance;

    public HistoricoAvance(Float nuevoAvance) {
        this.fechaActualizacion = new Date();
        this.nuevoAvance = nuevoAvance;
    }

    public Date getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(Date fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public Float getNuevoAvance() {
        return nuevoAvance;
    }

    public void setNuevoAvance(Float nuevoAvance) {
        this.nuevoAvance = nuevoAvance;
    }
}
