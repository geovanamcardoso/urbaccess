package br.com.fiap.urbaccess.bo;

import br.com.fiap.urbaccess.dao.UsuarioDAO;
import br.com.fiap.urbaccess.entities.Usuario;

import java.sql.SQLException;
import java.util.ArrayList;

public class UsuarioBo {

    public ArrayList<Usuario> selecionarBo() throws SQLException, ClassNotFoundException {
        UsuarioDAO dao = new UsuarioDAO();
        return (ArrayList<Usuario>) dao.selecionar();
    }

    public Usuario buscarPorIdBo(int id) throws SQLException, ClassNotFoundException {
        UsuarioDAO dao = new UsuarioDAO();
        return dao.buscarPorId(id);
    }

    public void inserirBo(Usuario u) throws SQLException, ClassNotFoundException {
        UsuarioDAO dao = new UsuarioDAO();
        dao.inserir(u);
    }

    public void atualizarBo(Usuario u) throws SQLException, ClassNotFoundException {
        UsuarioDAO dao = new UsuarioDAO();
        dao.atualizar(u);
    }

    public void deletarBo(int id) throws SQLException, ClassNotFoundException {
        UsuarioDAO dao = new UsuarioDAO();
        dao.deletar(id);
    }
}