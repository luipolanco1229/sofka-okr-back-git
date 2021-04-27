package co.com.sofka.okrs.domain;

import org.springframework.data.annotation.Id;

import java.util.Date;
import java.util.List;

public class Kr {
    @Id
    private String id;
    private String title;
    private Float percentageWeight;
    private String responsible;
    private String mail;
    private Date startDate;
    private Date finishDate;
    private List<UpdatePercentegeKr> updatePercentegeKr;
    private String  description;


    public Kr(String id, String title, Float percentageWeight, String responsible, String mail,
                      List<UpdatePercentegeKr> updatePercentegeKr, String description) {
        this.id = id;
        this.title = title;
        this.percentageWeight = percentageWeight;
        this.responsible = responsible;
        this.mail = mail;
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.updatePercentegeKr = updatePercentegeKr;
        this.description = description;
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

    public Float getPercentageWeight() {
        return percentageWeight;
    }

    public void setPercentageWeight(Float percentageWeight) {
        this.percentageWeight = percentageWeight;
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

    public Date getFinishDate() {
        return finishDate;
    }

    public List<UpdatePercentegeKr> getUpdatePercentegeKr() {
        return updatePercentegeKr;
    }

    public void setUpdatePercentegeKr(List<UpdatePercentegeKr> updatePercentegeKr) {
        this.updatePercentegeKr = updatePercentegeKr;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
