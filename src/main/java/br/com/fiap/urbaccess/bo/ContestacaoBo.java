package br.com.fiap.urbaccess.bo;

import br.com.fiap.urbaccess.dao.ContestacaoDAO;
import br.com.fiap.urbaccess.entities.Contestacao;

import java.sql.SQLException;
import java.util.ArrayList;

public class ContestacaoBo {

    public ArrayList<Contestacao> selecionarBo() throws SQLException, ClassNotFoundException {
        ContestacaoDAO dao = new ContestacaoDAO();
        return (ArrayList<Contestacao>) dao.selecionar();
    }

    public Contestacao buscarPorIdBo(int id) throws SQLException, ClassNotFoundException {
        ContestacaoDAO dao = new ContestacaoDAO();
        return dao.buscarPorId(id);
    }

    public ArrayList<Contestacao> buscarPorDenunciaBo(int idDenuncia)
            throws SQLException, ClassNotFoundException {
        ContestacaoDAO dao = new ContestacaoDAO();
        return (ArrayList<Contestacao>) dao.buscarPorDenuncia(idDenuncia);
    }

    public void inserirBo(Contestacao c) throws SQLException, ClassNotFoundException {
        ContestacaoDAO dao = new ContestacaoDAO();
        dao.inserir(c);
    }

    public void atualizarBo(Contestacao c) throws SQLException, ClassNotFoundException {
        ContestacaoDAO dao = new ContestacaoDAO();
        dao.atualizar(c);
    }

    public void deletarBo(int id) throws SQLException, ClassNotFoundException {
        ContestacaoDAO dao = new ContestacaoDAO();
        dao.deletar(id);
    }
}