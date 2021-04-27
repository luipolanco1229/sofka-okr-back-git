package co.com.sofka.okrs.dashboard_dto;

import java.util.Objects;

public class OkrList {

    private String id;
    private String title;
    private float okrProgress;

    public OkrList(String id, String title, float okrProgress) {
        this.id = Objects.requireNonNull(id);
        this.title = Objects.requireNonNull(title);
        this.okrProgress = Objects.requireNonNull(okrProgress);
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

    public float getOkrProgress() {
        return okrProgress;
    }

    public void setOkrProgress(float okrProgress) {
        this.okrProgress = okrProgress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OkrList okrList = (OkrList) o;
        return Float.compare(okrList.okrProgress, okrProgress) == 0 && Objects.equals(id, okrList.id) && Objects.equals(title, okrList.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, okrProgress);
    }
}
