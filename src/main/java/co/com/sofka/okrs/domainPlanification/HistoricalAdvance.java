package co.com.sofka.okrs.domainPlanification;

import org.springframework.data.annotation.Id;

import java.util.Date;

public class HistoricalAdvance {
    @Id
    private String id;
    private Float updatePercentegeOkr;
    private Date updateDate;

    public HistoricalAdvance(String id, Float updatePercentegeOkr) {
        this.id = id;
        this.updatePercentegeOkr = updatePercentegeOkr;
        this.updateDate = new Date();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Float getUpdatePercentegeOkr() {
        return updatePercentegeOkr;
    }

    public void setUpdatePercentegeOkr(Float updatePercentegeOkr) {
        this.updatePercentegeOkr = updatePercentegeOkr;
    }

    public Date getUpdateDate() {
        return updateDate;
    }
}
