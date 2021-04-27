package co.com.sofka.okrs.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document
public class Okr {

    @Id
    private String id;
    private String title;
    private String objective;
    private String responsible;
    private String mail;
    private String usuarioId;//TODO
    private String description;
    private String vertical;
    private Date startDate;
    private Date fechaFinalizacion;//TODO
    private Float avanceOkr;//TODO
    private List<HistoricoAvance> historialOkr;//TODO

    public Okr(String id, String title,
               String objective, String responsible, String mail,
               String usuarioId, String descripcionOkr, String vertical, Date startDate,
               Date fechaFinalizacion, Float avanceOkr, List<HistoricoAvance> historialOkr) {
        this.id = id;
        this.title = title;
        this.objective = objective;
        this.responsible = responsible;
        this.mail = mail;
        this.usuarioId = usuarioId;
        this.description = descripcionOkr;
        this.vertical = vertical;
        this.startDate = startDate;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getObjective() {
        return objective;
    }

    public void setObjective(String objective) {
        this.objective = objective;
    }

    public String getResponsible() {
        return responsible;
    }

    public void setResponsible(String responsible) {
        this.responsible = responsible;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(String usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVertical() {
        return vertical;
    }

    public void setVertical(String vertical) {
        this.vertical = vertical;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
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
