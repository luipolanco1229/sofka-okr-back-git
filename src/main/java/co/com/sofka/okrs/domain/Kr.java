package co.com.sofka.okrs.domain;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
public class Kr {

    @Id
    private String id;
    private String okrId;
    private String resultadoClave;
    private String nombreResponsableKr;
    private String correoResponsableKr;
    private Date fechaInicio;
    private Date fechaFinalizacion;
    private Float avanceKr;
    private Float pesoPorcentual;
    private String descripcionKr;

    public Kr(String id,
              String okrId,
              String resultadoClave,
              String nombreResponsableKr,
              String correoResponsableKr,
              Date fechaInicio,
              Date fechaFinalizacion,
              Float avanceKr,
              Float pesoPorcentual,
              String descripcionKr)
    {
        this.id = id;
        this.okrId = okrId;
        this.resultadoClave = resultadoClave;
        this.nombreResponsableKr = nombreResponsableKr;
        this.correoResponsableKr = correoResponsableKr;
        this.fechaInicio = fechaInicio;
        this.fechaFinalizacion = fechaFinalizacion;
        this.avanceKr = avanceKr;
        this.pesoPorcentual = pesoPorcentual;
        this.descripcionKr = descripcionKr;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOkrId() {
        return okrId;
    }

    public void setOkrId(String okrId) {
        this.okrId = okrId;
    }

    public String getResultadoClave() {
        return resultadoClave;
    }

    public void setResultadoClave(String resultadoClave) {
        this.resultadoClave = resultadoClave;
    }

    public String getNombreResponsableKr() {
        return nombreResponsableKr;
    }

    public void setNombreResponsableKr(String nombreResponsableKr) {
        this.nombreResponsableKr = nombreResponsableKr;
    }

    public String getCorreoResponsableKr() {
        return correoResponsableKr;
    }

    public void setCorreoResponsableKr(String correoResponsableKr) {
        this.correoResponsableKr = correoResponsableKr;
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

    public Float getAvanceKr() {
        return avanceKr;
    }

    public void setAvanceKr(Float avanceKr) {
        this.avanceKr = avanceKr;
    }

    public Float getPesoPorcentual() {
        return pesoPorcentual;
    }

    public void setPesoPorcentual(Float pesoPorcentual) {
        this.pesoPorcentual = pesoPorcentual;
    }

    public String getDescripcionKr() {
        return descripcionKr;
    }

    public void setDescripcionKr(String descripcionKr) {
        this.descripcionKr = descripcionKr;
    }
}
