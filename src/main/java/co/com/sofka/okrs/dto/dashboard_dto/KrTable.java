package co.com.sofka.okrs.dto.dashboard_dto;

import java.util.Objects;

public class KrTable {

    private String keyResult;
    private String personInChargeNameKr;
    private Float advanceKr;

    public KrTable(String keyResult, String personInChargeNameKr, Float advanceKr) {
        this.keyResult = keyResult;
        this.personInChargeNameKr = personInChargeNameKr;
        this.advanceKr = advanceKr;
    }

    public String getKeyResult() {
        return keyResult;
    }

    public void setKeyResult(String keyResult) {
        this.keyResult = keyResult;
    }

    public String getPersonInChargeNameKr() {
        return personInChargeNameKr;
    }

    public void setPersonInChargeNameKr(String personInChargeNameKr) {
        this.personInChargeNameKr = personInChargeNameKr;
    }

    public Float getAdvanceKr() {
        return advanceKr;
    }

    public void setAdvanceKr(Float advanceKr) {
        this.advanceKr = advanceKr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KrTable krTable = (KrTable) o;
        return Objects.equals(keyResult, krTable.keyResult) &&
                Objects.equals(personInChargeNameKr, krTable.personInChargeNameKr) &&
                Objects.equals(advanceKr, krTable.advanceKr);
    }

    @Override
    public int hashCode() {
        return Objects.hash(keyResult, personInChargeNameKr, advanceKr);
    }
}
