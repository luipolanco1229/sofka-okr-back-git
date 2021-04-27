package co.com.sofka.okrs.dashboard_dto;

import java.util.List;

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
}
