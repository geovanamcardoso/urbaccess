package br.com.fiap.urbaccess.dao;

import br.com.fiap.urbaccess.conexoes.ConexaoFactory;
import br.com.fiap.urbaccess.entities.Contestacao;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ContestacaoDAO {

    public Connection minhaConexao;

    public ContestacaoDAO() throws SQLException, ClassNotFoundException {
        super();
        this.minhaConexao = new ConexaoFactory().conexao();
    }

    public String inserir(Contestacao c) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement(
                "INSERT INTO CONTESTACAO (JUSTIFICATIVA, STATUS, PARECER_ADMIN, DT_CONTESTACAO, " +
                        "DT_ANALISE, ID_USUARIO, ID_DENUNCIA) VALUES (?, ?, ?, ?, ?, ?, ?)");

        stmt.setString(1, c.getJustificativa());
        stmt.setString(2, c.getStatus() != null ? c.getStatus() : "PENDENTE");
        stmt.setString(3, c.getParecerAdmin());
        stmt.setDate(4, Date.valueOf(c.getDtContestacao() != null ? c.getDtContestacao() : LocalDate.now()));

        if (c.getDtAnalise() != null) stmt.setDate(5, Date.valueOf(c.getDtAnalise()));
        else stmt.setNull(5, Types.DATE);
        stmt.setInt(6, c.getIdUsuario());
        stmt.setInt(7, c.getIdDenuncia());

        stmt.execute();
        stmt.close();

        return "Contestação cadastrada com sucesso!";
    }

    public String deletar(int id) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement(
                "DELETE FROM CONTESTACAO WHERE ID_CONTESTACAO = ?");

        stmt.setInt(1, id);

        stmt.execute();
        stmt.close();

        return "Contestação deletada com sucesso!";
    }

    public String atualizar(Contestacao c) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement(
                "UPDATE CONTESTACAO SET STATUS = ?, PARECER_ADMIN = ?, DT_ANALISE = ? " +
                        "WHERE ID_CONTESTACAO = ?");

        stmt.setString(1, c.getStatus());
        stmt.setString(2, c.getParecerAdmin());

        if (c.getDtAnalise() != null) stmt.setDate(3, Date.valueOf(c.getDtAnalise()));
        else stmt.setNull(3, Types.DATE);
        stmt.setInt(4, c.getIdContestacao());

        stmt.executeUpdate();
        stmt.close();

        return "Contestação atualizada com sucesso!";
    }

    public List<Contestacao> selecionar() throws SQLException {
        List<Contestacao> lista = new ArrayList<>();

        PreparedStatement stmt = minhaConexao.prepareStatement("SELECT * FROM CONTESTACAO");

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) lista.add(mapear(rs));
        rs.close();
        stmt.close();

        return lista;
    }

    public Contestacao buscarPorId(int id) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement(
                "SELECT * FROM CONTESTACAO WHERE ID_CONTESTACAO = ?");

        stmt.setInt(1, id);

        ResultSet rs = stmt.executeQuery();

        Contestacao c = null;

        if (rs.next()) c = mapear(rs);
        rs.close();
        stmt.close();

        return c;
    }

    public List<Contestacao> buscarPorDenuncia(int idDenuncia) throws SQLException {
        List<Contestacao> lista = new ArrayList<>();

        PreparedStatement stmt = minhaConexao.prepareStatement(
                "SELECT * FROM CONTESTACAO WHERE ID_DENUNCIA = ?");

        stmt.setInt(1, idDenuncia);

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) lista.add(mapear(rs));
        rs.close();
        stmt.close();

        return lista;
    }

    private Contestacao mapear(ResultSet rs) throws SQLException {
        Contestacao c = new Contestacao();

        c.setIdContestacao(rs.getInt("ID_CONTESTACAO"));
        c.setJustificativa(rs.getString("JUSTIFICATIVA"));
        c.setStatus(rs.getString("STATUS"));
        c.setParecerAdmin(rs.getString("PARECER_ADMIN"));
        Date dc = rs.getDate("DT_CONTESTACAO");

        if (dc != null) c.setDtContestacao(dc.toLocalDate());
        Date da = rs.getDate("DT_ANALISE");

        if (da != null) c.setDtAnalise(da.toLocalDate());
        c.setIdUsuario(rs.getInt("ID_USUARIO"));
        c.setIdDenuncia(rs.getInt("ID_DENUNCIA"));

        return c;
    }
}