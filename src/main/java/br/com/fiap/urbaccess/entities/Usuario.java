package br.com.fiap.urbaccess.entities;

import java.time.LocalDate;

public class Usuario {

    private int idUsuario;
    private String nome, email, senhaHash;
    private String tipoUsuario;      // CIDADAO | RESPONSAVEL | ADMIN
    private String perfilMobilidade; // CADEIRANTE | CARRINHO_BEBE | VISUAL | IDOSO | OUTRO
    private String ativo;            // S | N
    private LocalDate dtCadastro;

    public Usuario() {
    }

    public Usuario(int idUsuario, String nome, String email, String senhaHash, String tipoUsuario, String perfilMobilidade, String ativo, LocalDate dtCadastro) {
        this.idUsuario = idUsuario;
        this.nome = nome;
        this.email = email;
        this.senhaHash = senhaHash;
        this.tipoUsuario = tipoUsuario;
        this.perfilMobilidade = perfilMobilidade;
        this.ativo = ativo;
        this.dtCadastro = dtCadastro;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenhaHash() {
        return senhaHash;
    }

    public void setSenhaHash(String senhaHash) {
        this.senhaHash = senhaHash;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getPerfilMobilidade() {
        return perfilMobilidade;
    }

    public void setPerfilMobilidade(String perfilMobilidade) {
        this.perfilMobilidade = perfilMobilidade;
    }

    public String getAtivo() {
        return ativo;
    }

    public void setAtivo(String ativo) {
        this.ativo = ativo;
    }

    public LocalDate getDtCadastro() {
        return dtCadastro;
    }

    public void setDtCadastro(LocalDate dtCadastro) {
        this.dtCadastro = dtCadastro;
    }

    @Override
    public String toString() {
        return "\n\n -- USUÁRIO --" +
                "\nID Usuário: " + idUsuario +
                "\nNome: " + nome +
                "\nEmail:" + email +
                "\nSenha Hash: " + senhaHash +
                "\nTipo de usuário: " + tipoUsuario +
                "\nPerfil mobilidade='" + perfilMobilidade +
                "\nAtivo:" + ativo +
                "\nData de cadastro: " + dtCadastro;
    }
}
