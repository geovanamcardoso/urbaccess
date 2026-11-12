package br.com.fiap.urbaccess.main;

import br.com.fiap.urbaccess.dao.UsuarioDAO;
import br.com.fiap.urbaccess.entities.Usuario;
import br.com.fiap.urbaccess.excecoes.ExcecoesConexao;

import java.util.List;

public class TesteSelecionar {
    public static void main(String[] args) {
        try {
            UsuarioDAO dao = new UsuarioDAO();

            List<Usuario> lista = dao.selecionar();

            for (Usuario u : lista) {
                System.out.println(u);
            }
        } catch (Exception e) {
            new ExcecoesConexao(e);
        }
    }
}
