package br.com.fiap.urbaccess.main;

import br.com.fiap.urbaccess.dao.*;
import br.com.fiap.urbaccess.excecoes.ExcecoesConexao;

public class TesteDeletar {
    public static void main(String[] args) {
        try {

            System.out.println(new ContestacaoDAO().deletar(7));

            System.out.println(new AvaliacaoDAO().deletar(9));

            System.out.println(new DenunciaDAO().deletar(10));

            System.out.println(new EstabelecimentoDAO().deletar(9));

            System.out.println(new UsuarioDAO().deletar(12));

        } catch (Exception e) {
            new ExcecoesConexao(e);
        }
    }
}