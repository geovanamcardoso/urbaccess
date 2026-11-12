package br.com.fiap.urbaccess.bo;

import br.com.fiap.urbaccess.dao.EstabelecimentoDAO;
import br.com.fiap.urbaccess.entities.Estabelecimento;

import java.sql.SQLException;
import java.util.ArrayList;

public class EstabelecimentoBo {

    public ArrayList<Estabelecimento> selecionarBo() throws SQLException, ClassNotFoundException {
        EstabelecimentoDAO dao = new EstabelecimentoDAO();
        return (ArrayList<Estabelecimento>) dao.selecionar();
    }

    public Estabelecimento buscarPorIdBo(int id) throws SQLException, ClassNotFoundException {
        EstabelecimentoDAO dao = new EstabelecimentoDAO();
        return dao.buscarPorId(id);
    }

    public void inserirBo(Estabelecimento e) throws SQLException, ClassNotFoundException {
        EstabelecimentoDAO dao = new EstabelecimentoDAO();
        dao.inserir(e);
    }

    public void atualizarBo(Estabelecimento e) throws SQLException, ClassNotFoundException {
        EstabelecimentoDAO dao = new EstabelecimentoDAO();
        dao.atualizar(e);
    }

    public void deletarBo(int id) throws SQLException, ClassNotFoundException {
        EstabelecimentoDAO dao = new EstabelecimentoDAO();
        dao.deletar(id);
    }
}
