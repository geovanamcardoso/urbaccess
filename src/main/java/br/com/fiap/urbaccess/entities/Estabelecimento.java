package br.com.fiap.urbaccess.entities;

import java.time.LocalDate;

public class Estabelecimento {

    private int idEstabelecimento, idCategoria;
    private int idResponsavel; // 0 -> sem responsável
    private String nome, endereco, bairro, cidade, uf;
    private double latitude, longitude, notaAcessibilidade;
    private LocalDate dtCadastro;

    public Estabelecimento() {
    }

    public Estabelecimento(int idEstabelecimento, int idCategoria, int idResponsavel, String nome, String endereco, String bairro, String cidade, String uf, double latitude, double longitude, double notaAcessibilidade, LocalDate dtCadastro) {
        this.idEstabelecimento = idEstabelecimento;
        this.idCategoria = idCategoria;
        this.idResponsavel = idResponsavel;
        this.nome = nome;
        this.endereco = endereco;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
        this.latitude = latitude;
        this.longitude = longitude;
        this.notaAcessibilidade = notaAcessibilidade;
        this.dtCadastro = dtCadastro;
    }

    public int getIdEstabelecimento() {
        return idEstabelecimento;
    }

    public void setIdEstabelecimento(int idEstabelecimento) {
        this.idEstabelecimento = idEstabelecimento;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public int getIdResponsavel() {
        return idResponsavel;
    }

    public void setIdResponsavel(int idResponsavel) {
        this.idResponsavel = idResponsavel;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
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

    public double getNotaAcessibilidade() {
        return notaAcessibilidade;
    }

    public void setNotaAcessibilidade(double notaAcessibilidade) {
        this.notaAcessibilidade = notaAcessibilidade;
    }

    public LocalDate getDtCadastro() {
        return dtCadastro;
    }

    public void setDtCadastro(LocalDate dtCadastro) {
        this.dtCadastro = dtCadastro;
    }

    @Override
    public String toString() {
        return "\n\n -- ESTABELECIMENTO --" +
                "\nID Estabelecimento: " + idEstabelecimento +
                "\n ID Categoria: " + idCategoria +
                "\n ID Responsável: " + idResponsavel +
                "\nNome:" + nome +
                "\nEndereço: " + endereco +
                "\nBairro: " + bairro +
                "\nCidade: " + cidade +
                "\nUF:" + uf +
                "\nLatitude: " + latitude +
                "\nLongitude: " + longitude +
                "\nNota de Acessibilidade: " + notaAcessibilidade +
                "\nData do Cadastro: " + dtCadastro;
    }
}
