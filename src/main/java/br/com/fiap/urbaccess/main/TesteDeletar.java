package br.com.fiap.urbaccess.main;

import br.com.fiap.urbaccess.dao.UsuarioDAO;
import br.com.fiap.urbaccess.excecoes.ExcecoesConexao;

public class TesteDeletar {
    public static void main(String[] args) {
        try {
            UsuarioDAO dao = new UsuarioDAO();

            System.out.println(dao.deletar(22));

        } catch (Exception e) {
            new ExcecoesConexao(e);
        }
    }
}
