package co.com.sofka.okrs.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document
public class Okr {

    @Id
    private String id;
    private String titulo;
    private String objetivo;
    private String nombreResponsableOkr;
    private String correoResponsableOkr;
    private String usuarioId;
    private String descripcionOkr;
    private String vertical;
    private Date fechaInicio;
    private Date fechaFinalizacion;
    private Float avanceOkr;
    private List<HistoricoAvance> historialOkr;

    public Okr(String id, String titulo,
               String objetivo, String nombreResponsableOkr, String correoResponsableOkr,
               String usuarioId, String descripcionOkr, String vertical, Date fechaInicio,
               Date fechaFinalizacion, Float avanceOkr, List<HistoricoAvance> historialOkr) {
        this.id = id;
        this.titulo = titulo;
        this.objetivo = objetivo;
        this.nombreResponsableOkr = nombreResponsableOkr;
        this.correoResponsableOkr = correoResponsableOkr;
        this.usuarioId = usuarioId;
        this.descripcionOkr = descripcionOkr;
        this.vertical = vertical;
        this.fechaInicio = fechaInicio;
        this.fechaFinalizacion = fechaFinalizacion;
        this.avanceOkr = avanceOkr;
        this.historialOkr = historialOkr;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public String getNombreResponsableOkr() {
        return nombreResponsableOkr;
    }

    public void setNombreResponsableOkr(String nombreResponsableOkr) {
        this.nombreResponsableOkr = nombreResponsableOkr;
    }

    public String getCorreoResponsableOkr() {
        return correoResponsableOkr;
    }

    public void setCorreoResponsableOkr(String correoResponsableOkr) {
        this.correoResponsableOkr = correoResponsableOkr;
    }

    public String getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(String usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getDescripcionOkr() {
        return descripcionOkr;
    }

    public void setDescripcionOkr(String descripcionOkr) {
        this.descripcionOkr = descripcionOkr;
    }

    public String getVertical() {
        return vertical;
    }

    public void setVertical(String vertical) {
        this.vertical = vertical;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFinalizacion() {
        return fechaFinalizacion;
    }

    public void setFechaFinalizacion(Date fechaFinalizacion) {
        this.fechaFinalizacion = fechaFinalizacion;
    }

    public Float getAvanceOkr() {
        return avanceOkr;
    }

    public void setAvanceOkr(Float avanceOkr) {
        this.avanceOkr = avanceOkr;
    }

    public List<HistoricoAvance> getHistorialOkr() {
        return historialOkr;
    }

    public void setHistorialOkr(List<HistoricoAvance> historialOkr) {
        this.historialOkr = historialOkr;
    }
}
