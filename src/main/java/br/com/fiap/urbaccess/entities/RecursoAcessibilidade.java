package br.com.fiap.urbaccess.entities;

public class RecursoAcessibilidade {
    private int idRecurso;
    private String nome, descricao;

    public RecursoAcessibilidade() {
    }

    public RecursoAcessibilidade(int idRecurso, String nome, String descricao) {
        this.idRecurso = idRecurso;
        this.nome = nome;
        this.descricao = descricao;
    }

    public int getIdRecurso() {
        return idRecurso;
    }

    public void setIdRecurso(int idRecurso) {
        this.idRecurso = idRecurso;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "\n\n -- RECURSO ACESSIBILIDADE --" +
                "\nID Recurso: " + idRecurso +
                "\nNome: " + nome + '\'' +
                "\nDescrição: " + descricao;
    }
}
