package co.com.sofka.okrs.domain;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
public class Kr {

    @Id
    private String id;
    private String okrId;
    private String resultadoClave;//TODO: posiblemente es titulo en el modelo de Leonardo, no sé
    private String responsible;
    private String mail;
    private Date startDate;
    private Date finishDate;
    private Float avanceKr; //TODO
    private Float percentageWeight;
    private String description;
    //TODO: hay una lista que tienen ellos y no está en el modelo, revisar.

    public Kr(String id,
              String okrId,
              String resultadoClave,
              String responsible,
              String mail,
              Date startDate,
              Date finishDate,
              Float avanceKr,
              Float percentageWeight,
              String description)
    {
        this.id = id;
        this.okrId = okrId;
        this.resultadoClave = resultadoClave;
        this.responsible = responsible;
        this.mail = mail;
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.avanceKr = avanceKr;
        this.percentageWeight = percentageWeight;
        this.description = description;
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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    public Float getAvanceKr() {
        return avanceKr;
    }

    public void setAvanceKr(Float avanceKr) {
        this.avanceKr = avanceKr;
    }

    public Float getPercentageWeight() {
        return percentageWeight;
    }

    public void setPercentageWeight(Float percentageWeight) {
        this.percentageWeight = percentageWeight;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
