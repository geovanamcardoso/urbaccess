package br.com.fiap.urbaccess.entities;

import java.time.LocalDate;

public class Avaliacao {

    private int idAvaliacao, idUsuario, idEstabelecimento;
    private String comentario;
    private double notaCalculada;
    private LocalDate dtAvaliacao;

    public Avaliacao() {
    }

    public Avaliacao(int idAvaliacao, int idUsuario, int idEstabelecimento, String comentario, double notaCalculada, LocalDate dtAvaliacao) {
        this.idAvaliacao = idAvaliacao;
        this.idUsuario = idUsuario;
        this.idEstabelecimento = idEstabelecimento;
        this.comentario = comentario;
        this.notaCalculada = notaCalculada;
        this.dtAvaliacao = dtAvaliacao;
    }

    public int getIdAvaliacao() {
        return idAvaliacao;
    }

    public void setIdAvaliacao(int idAvaliacao) {
        this.idAvaliacao = idAvaliacao;
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

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public double getNotaCalculada() {
        return notaCalculada;
    }

    public void setNotaCalculada(double notaCalculada) {
        this.notaCalculada = notaCalculada;
    }

    public LocalDate getDtAvaliacao() {
        return dtAvaliacao;
    }

    public void setDtAvaliacao(LocalDate dtAvaliacao) {
        this.dtAvaliacao = dtAvaliacao;
    }

    @Override
    public String toString() {
        return "\n\n -- AVALIAÇÃO --" +
                "\nID Avaliação: " + idAvaliacao +
                "\nID Usuário: " + idUsuario +
                "\nID Estabelecimento: " + idEstabelecimento +
                "\nComentário: " + comentario + '\'' +
                "\nNota calculada: " + notaCalculada +
                "\nData da avaliaço=" + dtAvaliacao;
    }
}
