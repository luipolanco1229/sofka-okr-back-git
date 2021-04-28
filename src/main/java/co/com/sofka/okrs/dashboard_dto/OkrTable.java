package co.com.sofka.okrs.dashboard_dto;

import reactor.core.publisher.Flux;

import java.util.List;
import java.util.Objects;

public class OkrTabla {

    private String titulo;
    private String objetivo;
    private String nombreResponsableOkr;
    private List<KrTabla> resultadosClaves;

    public OkrTabla(String titulo, String objetivo, String nombreResponsableOkr, List<KrTabla> resultadosClaves) {
        this.titulo = titulo;
        this.objetivo = objetivo;
        this.nombreResponsableOkr = nombreResponsableOkr;
        this.resultadosClaves = resultadosClaves;
    }

    public OkrTabla(){}

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public String getNombreResponsableOkr() {
        return nombreResponsableOkr;
    }

    public void setNombreResponsableOkr(String nombreResponsableOkr) {
        this.nombreResponsableOkr = nombreResponsableOkr;
    }

    public List<KrTabla> getResultadosClaves() {
        return resultadosClaves;
    }

    public void setResultadosClaves(List<KrTabla> resultadosClaves) {
        this.resultadosClaves = resultadosClaves;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OkrTabla okrTabla = (OkrTabla) o;
        return Objects.equals(titulo, okrTabla.titulo) &&
                Objects.equals(objetivo, okrTabla.objetivo) &&
                Objects.equals(nombreResponsableOkr, okrTabla.nombreResponsableOkr) &&
                Objects.equals(resultadosClaves, okrTabla.resultadosClaves);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titulo, objetivo, nombreResponsableOkr, resultadosClaves);
    }
}
