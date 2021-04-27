package co.com.sofka.okrs.domain;

import org.springframework.data.annotation.Id;

import java.util.Date;

public class UpdatePercentegeKr {
    @Id
    private String id;
    private Float updatePercentege;
    private Date updateDate;

    public UpdatePercentegeKr(String id, Float updatePercentege) {
        this.id = id;
        this.updatePercentege = updatePercentege;
        this.updateDate = new Date();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Float getUpdatePercentege() {
        return updatePercentege;
    }

    public void setUpdatePercentege(Float updatePercentege) {
        this.updatePercentege = updatePercentege;
    }

    public Date getUpdateDate() {
        return updateDate;
    }
}
