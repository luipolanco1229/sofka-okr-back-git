package co.com.sofka.okrs.dashboard_dto;

public class OkrList {

    private String id;
    private String nombre;
    private float avancePorcentual;

    public OkrList(String id, String nombre, float avancePorcentual) {
        this.id = id;
        this.nombre = nombre;
        this.avancePorcentual = avancePorcentual;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getAvancePorcentual() {
        return avancePorcentual;
    }

    public void setAvancePorcentual(float avancePorcentual) {
        this.avancePorcentual = avancePorcentual;
    }
}
