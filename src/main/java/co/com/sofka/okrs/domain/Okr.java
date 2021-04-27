package co.com.sofka.okrs.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document(collection = "Okr")
public class Okr {
    @Id
    private String id;
    private String title;
    private String objective;
    private String vertical;
    private List<Kr> keyResults;
    private Date startDate;
    private String responsible;
    private String mail;
    private String  description;
    private List<UpdatePercentegeOkr>  updatePercentegeOkr;

    public Okr(String id, String title, String objective, String vertical, List<Kr> keyResults, String responsible,
                String mail, String description, List<UpdatePercentegeOkr> updatePercentegeOkr) {
        this.id = id;
        this.title = title;
        this.objective = objective;
        this.vertical = vertical;
        this.keyResults = keyResults;
        this.startDate = new Date();
        this.responsible = responsible;
        this.mail = mail;
        this.description = description;
        this.updatePercentegeOkr = updatePercentegeOkr;
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

    public String getVertical() {
        return vertical;
    }

    public void setVertical(String vertical) {
        this.vertical = vertical;
    }

    public List<Kr> getKeyResults() {
        return keyResults;
    }

    public void setKeyResults(List<Kr> keyResults) {
        this.keyResults = keyResults;
    }

    public Date getStartDate() {
        return startDate;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<UpdatePercentegeOkr> getUpdatePercentegeOkr() {
        return updatePercentegeOkr;
    }

    public void setUpdatePercentegeOkr(List<UpdatePercentegeOkr> updatePercentegeOkr) {
        this.updatePercentegeOkr = updatePercentegeOkr;
    }
}
