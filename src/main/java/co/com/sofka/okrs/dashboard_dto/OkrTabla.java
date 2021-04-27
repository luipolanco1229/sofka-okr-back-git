package co.com.sofka.okrs.dashboard_dto;

import reactor.core.publisher.Flux;

import java.util.List;

public class OkrTabla {

    private String titulo;
    private String objetivo;
    private String nombreResponsableOkr;
    private Flux<KrTabla> resultadosClaves;

    public OkrTabla(String titulo, String objetivo, String nombreResponsableOkr) {
        this.titulo = titulo;
        this.objetivo = objetivo;
        this.nombreResponsableOkr = nombreResponsableOkr;
    }

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

    public Flux<KrTabla> getResultadosClaves() {
        return resultadosClaves;
    }

    public void setResultadosClaves(Flux<KrTabla> resultadosClaves) {
        this.resultadosClaves = resultadosClaves;
    }
}
