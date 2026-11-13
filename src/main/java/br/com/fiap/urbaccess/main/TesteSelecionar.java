package br.com.fiap.urbaccess.main;

import br.com.fiap.urbaccess.dao.*;
import br.com.fiap.urbaccess.entities.*;
import br.com.fiap.urbaccess.excecoes.ExcecoesConexao;
import java.util.List;

public class TesteSelecionar {
    public static void main(String[] args) {
        try {

            System.out.println("\n\n -- LISTA DE USUÁRIOS --");
            List<Usuario> usuarios = new UsuarioDAO().selecionar();
            for (Usuario u : usuarios) System.out.println(u);

            System.out.println("\n\n -- LISTAS DE ESTABELECIMENTOS --");
            List<Estabelecimento> estabelecimentos = new EstabelecimentoDAO().selecionar();
            for (Estabelecimento e : estabelecimentos) System.out.println(e);

            System.out.println("\n\n -- LISTA DE DENÚNCIAS --");
            List<Denuncia> denuncias = new DenunciaDAO().selecionar();
            for (Denuncia d : denuncias) System.out.println(d);

            System.out.println("\n\n -- LISTA DE AVALIAÇÕES -- ");
            List<Avaliacao> avaliacoes = new AvaliacaoDAO().selecionar();
            for (Avaliacao a : avaliacoes) System.out.println(a);

            System.out.println("\n\n -- LISTA DE CONTESTAÇÕES --");
            List<Contestacao> contestacoes = new ContestacaoDAO().selecionar();
            for (Contestacao c : contestacoes) System.out.println(c);

        } catch (Exception e) {
            new ExcecoesConexao(e);
        }
    }
}