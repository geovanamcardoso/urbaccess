package br.com.fiap.urbaccess.dao;

import br.com.fiap.urbaccess.conexoes.ConexaoFactory;
import br.com.fiap.urbaccess.entities.Denuncia;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DenunciaDAO {

    public Connection minhaConexao;

    public DenunciaDAO() throws SQLException, ClassNotFoundException {
        super();
        this.minhaConexao = new ConexaoFactory().conexao();
    }

    public String inserir(Denuncia d) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement(
                "INSERT INTO DENUNCIA (DESCRICAO, URL_FOTO, LATITUDE, LONGITUDE, STATUS, " +
                        "DT_ABERTURA, DT_PRAZO, DT_RESOLUCAO, DESCRICAO_CORRECAO, URL_FOTO_CORRECAO, " +
                        "ID_MODERADOR, ID_USUARIO, ID_ESTABELECIMENTO, ID_RECURSO) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
        stmt.setString(1, d.getDescricao());
        stmt.setString(2, d.getUrlFoto());
        stmt.setDouble(3, d.getLatitude());
        stmt.setDouble(4, d.getLongitude());
        stmt.setString(5, d.getStatus() != null ? d.getStatus() : "ABERTA");
        stmt.setDate(6, Date.valueOf(d.getDtAbertura() != null ? d.getDtAbertura() : LocalDate.now()));

        if (d.getDtPrazo() != null) stmt.setDate(7, Date.valueOf(d.getDtPrazo()));
        else stmt.setNull(7, Types.DATE);

        if (d.getDtResolucao() != null) stmt.setDate(8, Date.valueOf(d.getDtResolucao()));
        else stmt.setNull(8, Types.DATE);

        stmt.setString(9, d.getDescricaoCorrecao());

        stmt.setString(10, d.getUrlFotoCorrecao());

        if (d.getIdModerador() == 0) stmt.setNull(11, Types.INTEGER);
        else stmt.setInt(11, d.getIdModerador());

        stmt.setInt(12, d.getIdUsuario());
        stmt.setInt(13, d.getIdEstabelecimento());
        stmt.setInt(14, d.getIdRecurso());

        stmt.execute();
        stmt.close();

        return "Denúncia cadastrada com sucesso!";
    }

    public String deletar(int id) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement(
                "DELETE FROM DENUNCIA WHERE ID_DENUNCIA = ?");
        stmt.setInt(1, id);
        stmt.execute();
        stmt.close();
        return "Denúncia deletada com sucesso!";
    }

    public String atualizarStatus(int id, String novoStatus) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement(
                "UPDATE DENUNCIA SET STATUS = ? WHERE ID_DENUNCIA = ?");
        stmt.setString(1, novoStatus);
        stmt.setInt(2, id);
        stmt.executeUpdate();
        stmt.close();
        return "Status atualizado com sucesso!";
    }

    public List<Denuncia> selecionar() throws SQLException {
        List<Denuncia> lista = new ArrayList<>();
        PreparedStatement stmt = minhaConexao.prepareStatement("SELECT * FROM DENUNCIA");
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) lista.add(mapear(rs));
        rs.close();
        stmt.close();
        return lista;
    }

    public Denuncia buscarPorId(int id) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement(
                "SELECT * FROM DENUNCIA WHERE ID_DENUNCIA = ?");
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        Denuncia d = null;
        if (rs.next()) d = mapear(rs);
        rs.close();
        stmt.close();
        return d;
    }

    private Denuncia mapear(ResultSet rs) throws SQLException {
        Denuncia d = new Denuncia();

        d.setIdDenuncia(rs.getInt("ID_DENUNCIA"));
        d.setDescricao(rs.getString("DESCRICAO"));
        d.setUrlFoto(rs.getString("URL_FOTO"));
        d.setLatitude(rs.getDouble("LATITUDE"));
        d.setLongitude(rs.getDouble("LONGITUDE"));
        d.setStatus(rs.getString("STATUS"));
        Date ab = rs.getDate("DT_ABERTURA");

        if (ab != null) d.setDtAbertura(ab.toLocalDate());
        Date pr = rs.getDate("DT_PRAZO");

        if (pr != null) d.setDtPrazo(pr.toLocalDate());
        Date re = rs.getDate("DT_RESOLUCAO");

        if (re != null) d.setDtResolucao(re.toLocalDate());
        d.setDescricaoCorrecao(rs.getString("DESCRICAO_CORRECAO"));

        d.setUrlFotoCorrecao(rs.getString("URL_FOTO_CORRECAO"));

        d.setIdModerador(rs.getInt("ID_MODERADOR"));

        d.setIdUsuario(rs.getInt("ID_USUARIO"));

        d.setIdEstabelecimento(rs.getInt("ID_ESTABELECIMENTO"));

        d.setIdRecurso(rs.getInt("ID_RECURSO"));

        return d;
    }
}