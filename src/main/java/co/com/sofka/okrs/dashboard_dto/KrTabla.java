package co.com.sofka.okrs.dashboard_dto;

public class KrTabla {

    private String resultadoClave;
    private String nombreResponsableKr;
    private Float avanceKr;

    public KrTabla(String resultadoClave, String nombreResponsableKr, Float avanceKr) {
        this.resultadoClave = resultadoClave;
        this.nombreResponsableKr = nombreResponsableKr;
        this.avanceKr = avanceKr;
    }

    public String getResultadoClave() {
        return resultadoClave;
    }

    public void setResultadoClave(String resultadoClave) {
        this.resultadoClave = resultadoClave;
    }

    public String getNombreResponsableKr() {
        return nombreResponsableKr;
    }

    public void setNombreResponsableKr(String nombreResponsableKr) {
        this.nombreResponsableKr = nombreResponsableKr;
    }

    public Float getAvanceKr() {
        return avanceKr;
    }

    public void setAvanceKr(Float avanceKr) {
        this.avanceKr = avanceKr;
    }
}
