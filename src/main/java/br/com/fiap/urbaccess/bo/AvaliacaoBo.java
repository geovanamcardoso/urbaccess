package br.com.fiap.urbaccess.bo;

import br.com.fiap.urbaccess.dao.AvaliacaoDAO;
import br.com.fiap.urbaccess.entities.Avaliacao;

import java.sql.SQLException;
import java.util.ArrayList;

public class AvaliacaoBo {

    public ArrayList<Avaliacao> selecionarBo() throws SQLException, ClassNotFoundException {
        AvaliacaoDAO dao = new AvaliacaoDAO();
        return (ArrayList<Avaliacao>) dao.selecionar();
    }

    public Avaliacao buscarPorIdBo(int id) throws SQLException, ClassNotFoundException {
        AvaliacaoDAO dao = new AvaliacaoDAO();
        return dao.buscarPorId(id);
    }

    public ArrayList<Avaliacao> buscarPorEstabelecimentoBo(int idEstabelecimento)
            throws SQLException, ClassNotFoundException {
        AvaliacaoDAO dao = new AvaliacaoDAO();
        return (ArrayList<Avaliacao>) dao.buscarPorEstabelecimento(idEstabelecimento);
    }

    public void inserirBo(Avaliacao a) throws SQLException, ClassNotFoundException {
        AvaliacaoDAO dao = new AvaliacaoDAO();
        dao.inserir(a);
    }

    public void atualizarBo(Avaliacao a) throws SQLException, ClassNotFoundException {
        AvaliacaoDAO dao = new AvaliacaoDAO();
        dao.atualizar(a);
    }

    public void deletarBo(int id) throws SQLException, ClassNotFoundException {
        AvaliacaoDAO dao = new AvaliacaoDAO();
        dao.deletar(id);
    }
}