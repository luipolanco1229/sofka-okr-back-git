package co.com.sofka.okrs.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document(collection = "Okr")
public class Okr {

    private String id;
    private String title;
    private String objective;
    private String personInChargeNameOkr;
    private String personInChargeEmailOkr;
    private String userId;
    private String descriptionOkr;
    private String vertical;
    private Date startDate;
    private Float advanceOkr;
    private List<HistoricalAdvance> historicalOkr;

    public Okr(String id, String title, String objective, String personInChargeNameOkr, String personInChargeEmailOkr, String descriptionOkr, String vertical,
               Float advanceOkr, List<HistoricalAdvance> historicalOkr, String userId) {
        this.id = id;
        this.title = title;
        this.objective = objective;
        this.personInChargeNameOkr = personInChargeNameOkr;
        this.personInChargeEmailOkr = personInChargeEmailOkr;
        this.descriptionOkr = descriptionOkr;
        this.vertical = vertical;
        this.startDate = new Date();
        this.advanceOkr = advanceOkr;
        this.historicalOkr = historicalOkr;
        this.userId = userId;
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

    public String getPersonInChargeNameOkr() {
        return personInChargeNameOkr;
    }

    public void setPersonInChargeNameOkr(String personInChargeNameOkr) {
        this.personInChargeNameOkr = personInChargeNameOkr;
    }

    public String getPersonInChargeEmailOkr() {
        return personInChargeEmailOkr;
    }

    public void setPersonInChargeEmailOkr(String personInChargeEmailOkr) {
        this.personInChargeEmailOkr = personInChargeEmailOkr;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDescriptionOkr() {
        return descriptionOkr;
    }

    public void setDescriptionOkr(String descriptionOkr) {
        this.descriptionOkr = descriptionOkr;
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

    public Float getAdvanceOkr() {
        return advanceOkr;
    }

    public void setAdvanceOkr(Float advanceOkr) {
        this.advanceOkr = advanceOkr;
    }

    public List<HistoricalAdvance> getHistoricalOkr() {
        return historicalOkr;
    }

    public void setHistoricalOkr(List<HistoricalAdvance> historicalOkr) {
        this.historicalOkr = historicalOkr;
    }
}
