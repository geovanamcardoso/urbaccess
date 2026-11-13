package br.com.fiap.urbaccess.main;

import br.com.fiap.urbaccess.dao.*;
import br.com.fiap.urbaccess.excecoes.ExcecoesConexao;

public class TesteDeletar {
    public static void main(String[] args) {
        try {

            System.out.println(new ContestacaoDAO().deletar(1));

            System.out.println(new AvaliacaoDAO().deletar(1));

            System.out.println(new DenunciaDAO().deletar(1));

            System.out.println(new EstabelecimentoDAO().deletar(1));

            System.out.println(new UsuarioDAO().deletar(21));

        } catch (Exception e) {
            new ExcecoesConexao(e);
        }
    }
}