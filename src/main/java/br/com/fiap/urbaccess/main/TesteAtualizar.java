package br.com.fiap.urbaccess.main;

import br.com.fiap.urbaccess.dao.UsuarioDAO;
import br.com.fiap.urbaccess.entities.Usuario;
import br.com.fiap.urbaccess.excecoes.ExcecoesConexao;

public class TesteAtualizar {
    public static void main(String[] args) {
        try {
                Usuario u = new Usuario();
                u.setIdUsuario(21);
                u.setNome("Débora Olivera Atualizada");
                u.setTipoUsuario("ADMIN");
                u.setPerfilMobilidade("CADEIRANTE");
                u.setAtivo("S");

                UsuarioDAO dao = new UsuarioDAO();
                System.out.println(dao.atualizar(u));

        } catch (Exception e) {
            new ExcecoesConexao(e);
        }
    }
}

