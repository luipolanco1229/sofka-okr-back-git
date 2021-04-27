package co.com.sofka.okrs.dashboard_dto;

public class OkrLista {

    private String id;
    private String titulo;
    private float avanceOkr;

    public OkrLista(String id, String titulo, float avanceOkr) {
        this.id = id;
        this.titulo = titulo;
        this.avanceOkr = avanceOkr;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public float getAvanceOkr() {
        return avanceOkr;
    }

    public void setAvanceOkr(float avanceOkr) {
        this.avanceOkr = avanceOkr;
    }
}
