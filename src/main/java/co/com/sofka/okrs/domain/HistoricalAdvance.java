package co.com.sofka.okrs.domain;

import java.util.Date;

public class HistoricalAdvance {

    private Date dateUpdate;
    private Float newAdvance;

    public HistoricalAdvance(Float newAdvance) {
        this.dateUpdate = new Date();
        this.newAdvance = newAdvance;
    }

    public Date getDateUpdate() {
        return dateUpdate;
    }

    public void setDateUpdate(Date dateUpdate) {
        this.dateUpdate = dateUpdate;
    }

    public Float getNewAdvance() {
        return newAdvance;
    }

    public void setNewAdvance(Float newAdvance) {
        this.newAdvance = newAdvance;
    }
}
