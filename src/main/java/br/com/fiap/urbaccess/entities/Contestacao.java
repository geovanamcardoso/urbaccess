package br.com.fiap.urbaccess.entities;

import java.time.LocalDate;

public class Contestacao {

    private int idContestacao, idUsuario, idDenuncia;
    private String justificativa, parecerAdmin;
    private String status; // PENDENTE | ACEITA | REJEITADA
    private LocalDate dtContestacao, dtAnalise;

    public Contestacao() {
    }

    public Contestacao(int idContestacao, int idUsuario, int idDenuncia, String justificativa, String parecerAdmin, String status, LocalDate dtContestacao, LocalDate dtAnalise) {
        this.idContestacao = idContestacao;
        this.idUsuario = idUsuario;
        this.idDenuncia = idDenuncia;
        this.justificativa = justificativa;
        this.parecerAdmin = parecerAdmin;
        this.status = status;
        this.dtContestacao = dtContestacao;
        this.dtAnalise = dtAnalise;
    }

    public int getIdContestacao() {
        return idContestacao;
    }

    public void setIdContestacao(int idContestacao) {
        this.idContestacao = idContestacao;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdDenuncia() {
        return idDenuncia;
    }

    public void setIdDenuncia(int idDenuncia) {
        this.idDenuncia = idDenuncia;
    }

    public String getJustificativa() {
        return justificativa;
    }

    public void setJustificativa(String justificativa) {
        this.justificativa = justificativa;
    }

    public String getParecerAdmin() {
        return parecerAdmin;
    }

    public void setParecerAdmin(String parecerAdmin) {
        this.parecerAdmin = parecerAdmin;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getDtContestacao() {
        return dtContestacao;
    }

    public void setDtContestacao(LocalDate dtContestacao) {
        this.dtContestacao = dtContestacao;
    }

    public LocalDate getDtAnalise() {
        return dtAnalise;
    }

    public void setDtAnalise(LocalDate dtAnalise) {
        this.dtAnalise = dtAnalise;
    }

    @Override
    public String toString() {
        return "\n\n -- CONTESTAÇÃO --" +
                "\nID Contestação:" + idContestacao +
                "\nID Usuário: " + idUsuario +
                "\nID Denúncia: " + idDenuncia +
                "\nJustificativa: " + justificativa +
                "\nParecer Admin:" + parecerAdmin +
                "\nStatus: " + status +
                "\nData da Contestação: " + dtContestacao +
                "\nData da Análise:" + dtAnalise;
    }
}
