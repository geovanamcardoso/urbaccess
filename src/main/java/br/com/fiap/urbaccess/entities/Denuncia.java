package br.com.fiap.urbaccess.entities;

import java.time.LocalDate;

public class Denuncia {

    private int idDenuncia, idUsuario, idEstabelecimento, idRecurso;
    private int idModerador;   // 0 = sem moderador
    private String descricao, urlFoto, descricaoCorrecao, urlFotoCorrecao;
    private String status; // ABERTA | EM_PRAZO | RESOLVIDA | VENCIDA | EM_CONTESTACAO | REJEITADA
    private double latitude, longitude;
    private LocalDate dtAbertura, dtPrazo, dtResolucao;

    public Denuncia() {
    }

    public Denuncia(int idDenuncia, int idUsuario, int idEstabelecimento, int idRecurso, int idModerador, String descricao, String urlFoto, String descricaoCorrecao, String urlFotoCorrecao, String status, double latitude, double longitude, LocalDate dtAbertura, LocalDate dtPrazo, LocalDate dtResolucao) {
        this.idDenuncia = idDenuncia;
        this.idUsuario = idUsuario;
        this.idEstabelecimento = idEstabelecimento;
        this.idRecurso = idRecurso;
        this.idModerador = idModerador;
        this.descricao = descricao;
        this.urlFoto = urlFoto;
        this.descricaoCorrecao = descricaoCorrecao;
        this.urlFotoCorrecao = urlFotoCorrecao;
        this.status = status;
        this.latitude = latitude;
        this.longitude = longitude;
        this.dtAbertura = dtAbertura;
        this.dtPrazo = dtPrazo;
        this.dtResolucao = dtResolucao;
    }

    public int getIdDenuncia() {
        return idDenuncia;
    }

    public void setIdDenuncia(int idDenuncia) {
        this.idDenuncia = idDenuncia;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdEstabelecimento() {
        return idEstabelecimento;
    }

    public void setIdEstabelecimento(int idEstabelecimento) {
        this.idEstabelecimento = idEstabelecimento;
    }

    public int getIdRecurso() {
        return idRecurso;
    }

    public void setIdRecurso(int idRecurso) {
        this.idRecurso = idRecurso;
    }

    public int getIdModerador() {
        return idModerador;
    }

    public void setIdModerador(int idModerador) {
        this.idModerador = idModerador;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    public String getDescricaoCorrecao() {
        return descricaoCorrecao;
    }

    public void setDescricaoCorrecao(String descricaoCorrecao) {
        this.descricaoCorrecao = descricaoCorrecao;
    }

    public String getUrlFotoCorrecao() {
        return urlFotoCorrecao;
    }

    public void setUrlFotoCorrecao(String urlFotoCorrecao) {
        this.urlFotoCorrecao = urlFotoCorrecao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public LocalDate getDtAbertura() {
        return dtAbertura;
    }

    public void setDtAbertura(LocalDate dtAbertura) {
        this.dtAbertura = dtAbertura;
    }

    public LocalDate getDtPrazo() {
        return dtPrazo;
    }

    public void setDtPrazo(LocalDate dtPrazo) {
        this.dtPrazo = dtPrazo;
    }

    public LocalDate getDtResolucao() {
        return dtResolucao;
    }

    public void setDtResolucao(LocalDate dtResolucao) {
        this.dtResolucao = dtResolucao;
    }

    @Override
    public String toString() {
        return "\n\n -- DENÚNCIA --" +
                "\nID Denúncia: " + idDenuncia +
                "\n ID Usuário: " + idUsuario +
                "\n ID Estabelecimento: " + idEstabelecimento +
                "\nID Recurso: " + idRecurso +
                "\n ID Moderador: " + idModerador +
                "\nDescrição: " + descricao +
                "\nURL Foto: " + urlFoto +
                "\nDescrição da Correção='" + descricaoCorrecao +
                "\nURL Foto da Correção:" + urlFotoCorrecao +
                "\nStatus: " + status +
                "\nLatitude: " + latitude +
                "\nLongitude: " + longitude +
                "\nData de Abertura: " + dtAbertura +
                "\nData do Prazo:" + dtPrazo +
                "\nData da Resolução: " + dtResolucao;
    }
}
