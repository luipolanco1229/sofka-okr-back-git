package co.com.sofka.okrs.dashboard_dto;

import java.util.List;
import java.util.Objects;

public class OkrTable {

    private String title;
    private String objective;
    private String personInChargeNameOkr;
    private List<KrTable> keyResults;

    public OkrTable(String title, String objective, String personInChargeNameOkr, List<KrTable> keyResults) {
        this.title = title;
        this.objective = objective;
        this.personInChargeNameOkr = personInChargeNameOkr;
        this.keyResults = keyResults;
    }

    public OkrTable(){}

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

    public List<KrTable> getKeyResults() {
        return keyResults;
    }

    public void setKeyResults(List<KrTable> keyResults) {
        this.keyResults = keyResults;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OkrTable okrTable = (OkrTable) o;
        return Objects.equals(title, okrTable.title) &&
                Objects.equals(objective, okrTable.objective) &&
                Objects.equals(personInChargeNameOkr, okrTable.personInChargeNameOkr) &&
                Objects.equals(keyResults, okrTable.keyResults);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, objective, personInChargeNameOkr, keyResults);
    }
}
