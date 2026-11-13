package br.com.fiap.urbaccess.dao;

import br.com.fiap.urbaccess.conexoes.ConexaoFactory;
import br.com.fiap.urbaccess.entities.Avaliacao;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AvaliacaoDAO {

    public Connection minhaConexao;

    public AvaliacaoDAO() throws SQLException, ClassNotFoundException {
        super();
        this.minhaConexao = new ConexaoFactory().conexao();
    }

    public String inserir(Avaliacao a) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement(
                "INSERT INTO AVALIACAO (COMENTARIO, NOTA_CALCULADA, DT_AVALIACAO, ID_USUARIO, ID_ESTABELECIMENTO) " +
                        "VALUES (?, ?, ?, ?, ?)");

        stmt.setString(1, a.getComentario());
        stmt.setDouble(2, a.getNotaCalculada());
        stmt.setDate(3, Date.valueOf(a.getDtAvaliacao() != null ? a.getDtAvaliacao() : LocalDate.now()));
        stmt.setInt(4, a.getIdUsuario());
        stmt.setInt(5, a.getIdEstabelecimento());

        stmt.execute();
        stmt.close();
        minhaConexao.close();
        return "Avaliação cadastrada com sucesso!";
    }

    public String deletar(int id) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement(
                "DELETE FROM AVALIACAO WHERE ID_AVALIACAO = ?");

        stmt.setInt(1, id);

        stmt.execute();
        stmt.close();
        minhaConexao.close();
        return "Avaliação deletada com sucesso!";
    }

    public String atualizar(Avaliacao a) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement(
                "UPDATE AVALIACAO SET COMENTARIO = ?, NOTA_CALCULADA = ? WHERE ID_AVALIACAO = ?");

        stmt.setString(1, a.getComentario());
        stmt.setDouble(2, a.getNotaCalculada());
        stmt.setInt(3, a.getIdAvaliacao());

        stmt.executeUpdate();
        stmt.close();
        minhaConexao.close();

        return "Avaliação atualizada com sucesso!";
    }

    public List<Avaliacao> selecionar() throws SQLException {
        List<Avaliacao> lista = new ArrayList<>();

        PreparedStatement stmt = minhaConexao.prepareStatement("SELECT * FROM AVALIACAO");

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) lista.add(mapear(rs));
        rs.close();
        stmt.close();
        minhaConexao.close();
        return lista;
    }

    public Avaliacao buscarPorId(int id) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement(
                "SELECT * FROM AVALIACAO WHERE ID_AVALIACAO = ?");

        stmt.setInt(1, id);

        ResultSet rs = stmt.executeQuery();

        Avaliacao a = null;

        if (rs.next()) a = mapear(rs);
        rs.close();
        stmt.close();
        minhaConexao.close();
        return a;
    }

    public List<Avaliacao> buscarPorEstabelecimento(int idEstabelecimento) throws SQLException {
        List<Avaliacao> lista = new ArrayList<>();

        PreparedStatement stmt = minhaConexao.prepareStatement(
                "SELECT * FROM AVALIACAO WHERE ID_ESTABELECIMENTO = ?");

        stmt.setInt(1, idEstabelecimento);

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) lista.add(mapear(rs));

        rs.close();
        stmt.close();
        minhaConexao.close();
        return lista;
    }

    private Avaliacao mapear(ResultSet rs) throws SQLException {
        Avaliacao a = new Avaliacao();

        a.setIdAvaliacao(rs.getInt("ID_AVALIACAO"));
        a.setComentario(rs.getString("COMENTARIO"));
        a.setNotaCalculada(rs.getDouble("NOTA_CALCULADA"));
        Date d = rs.getDate("DT_AVALIACAO");

        if (d != null) a.setDtAvaliacao(d.toLocalDate());
        a.setIdUsuario(rs.getInt("ID_USUARIO"));
        a.setIdEstabelecimento(rs.getInt("ID_ESTABELECIMENTO"));

        return a;
    }
}