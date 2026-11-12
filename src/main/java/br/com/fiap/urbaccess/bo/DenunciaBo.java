package br.com.fiap.urbaccess.bo;

import br.com.fiap.urbaccess.dao.DenunciaDAO;
import br.com.fiap.urbaccess.entities.Denuncia;

import java.sql.SQLException;
import java.util.ArrayList;

public class DenunciaBo {

    public ArrayList<Denuncia> selecionarBo() throws SQLException, ClassNotFoundException {
        DenunciaDAO dao = new DenunciaDAO();
        return (ArrayList<Denuncia>) dao.selecionar();
    }

    public Denuncia buscarPorIdBo(int id) throws SQLException, ClassNotFoundException {
        DenunciaDAO dao = new DenunciaDAO();
        return dao.buscarPorId(id);
    }

    public void inserirBo(Denuncia d) throws SQLException, ClassNotFoundException {
        DenunciaDAO dao = new DenunciaDAO();
        dao.inserir(d);
    }

    public void atualizarStatusBo(int id, String novoStatus)
            throws SQLException, ClassNotFoundException {
        DenunciaDAO dao = new DenunciaDAO();
        dao.atualizarStatus(id, novoStatus);
    }

    public void deletarBo(int id) throws SQLException, ClassNotFoundException {
        DenunciaDAO dao = new DenunciaDAO();
        dao.deletar(id);
    }
}