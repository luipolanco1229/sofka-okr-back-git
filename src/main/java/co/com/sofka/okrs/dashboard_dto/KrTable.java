package co.com.sofka.okrs.dashboard_dto;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KrTabla krTabla = (KrTabla) o;
        return Objects.equals(resultadoClave, krTabla.resultadoClave) &&
                Objects.equals(nombreResponsableKr, krTabla.nombreResponsableKr) &&
                Objects.equals(avanceKr, krTabla.avanceKr);
    }

    @Override
    public int hashCode() {
        return Objects.hash(resultadoClave, nombreResponsableKr, avanceKr);
    }
}
