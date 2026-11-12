package br.com.fiap.urbaccess.dao;

import br.com.fiap.urbaccess.conexoes.ConexaoFactory;
import br.com.fiap.urbaccess.entities.Estabelecimento;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EstabelecimentoDAO {

    public Connection minhaConexao;

    public EstabelecimentoDAO() throws SQLException, ClassNotFoundException {
        super();
        this.minhaConexao = new ConexaoFactory().conexao();
    }

    public String inserir(Estabelecimento e) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement(
                "INSERT INTO ESTABELECIMENTO (NOME, ENDERECO, BAIRRO, CIDADE, UF, LATITUDE, LONGITUDE, " +
                        "NOTA_ACESSIBILIDADE, DT_CADASTRO, ID_CATEGORIA, ID_RESPONSAVEL) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
        stmt.setString(1, e.getNome());
        stmt.setString(2, e.getEndereco());
        stmt.setString(3, e.getBairro());
        stmt.setString(4, e.getCidade());
        stmt.setString(5, e.getUf());
        stmt.setDouble(6, e.getLatitude());
        stmt.setDouble(7, e.getLongitude());
        stmt.setDouble(8, e.getNotaAcessibilidade());
        stmt.setDate(9, Date.valueOf(e.getDtCadastro() != null ? e.getDtCadastro() : LocalDate.now()));
        stmt.setInt(10, e.getIdCategoria());
        if (e.getIdResponsavel() == 0) stmt.setNull(11, Types.INTEGER);
        else stmt.setInt(11, e.getIdResponsavel());
        stmt.execute();
        stmt.close();
        return "Estabelecimento cadastrado com sucesso!";
    }

    public String deletar(int id) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement(
                "DELETE FROM ESTABELECIMENTO WHERE ID_ESTABELECIMENTO = ?");
        stmt.setInt(1, id);
        stmt.execute();
        stmt.close();
        return "Estabelecimento deletado com sucesso!";
    }

    public String atualizar(Estabelecimento e) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement(
                "UPDATE ESTABELECIMENTO SET NOME = ?, ENDERECO = ?, BAIRRO = ?, CIDADE = ?, " +
                        "UF = ?, LATITUDE = ?, LONGITUDE = ?, ID_CATEGORIA = ? " +
                        "WHERE ID_ESTABELECIMENTO = ?");
        stmt.setString(1, e.getNome());
        stmt.setString(2, e.getEndereco());
        stmt.setString(3, e.getBairro());
        stmt.setString(4, e.getCidade());
        stmt.setString(5, e.getUf());
        stmt.setDouble(6, e.getLatitude());
        stmt.setDouble(7, e.getLongitude());
        stmt.setInt(8, e.getIdCategoria());
        stmt.setInt(9, e.getIdEstabelecimento());
        stmt.executeUpdate();
        stmt.close();
        return "Estabelecimento atualizado com sucesso!";
    }

    public List<Estabelecimento> selecionar() throws SQLException {
        List<Estabelecimento> lista = new ArrayList<>();
        PreparedStatement stmt = minhaConexao.prepareStatement("SELECT * FROM ESTABELECIMENTO");
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            lista.add(mapear(rs));
        }
        rs.close();
        stmt.close();
        return lista;
    }

    public Estabelecimento buscarPorId(int id) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement(
                "SELECT * FROM ESTABELECIMENTO WHERE ID_ESTABELECIMENTO = ?");
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        Estabelecimento e = null;
        if (rs.next()) e = mapear(rs);
        rs.close();
        stmt.close();
        return e;
    }

    private Estabelecimento mapear(ResultSet rs) throws SQLException {
        Estabelecimento e = new Estabelecimento();

        e.setIdEstabelecimento(rs.getInt("ID_ESTABELECIMENTO"));
        e.setNome(rs.getString("NOME"));
        e.setEndereco(rs.getString("ENDERECO"));
        e.setBairro(rs.getString("BAIRRO"));
        e.setCidade(rs.getString("CIDADE"));
        e.setUf(rs.getString("UF"));
        e.setLatitude(rs.getDouble("LATITUDE"));
        e.setLongitude(rs.getDouble("LONGITUDE"));
        e.setNotaAcessibilidade(rs.getDouble("NOTA_ACESSIBILIDADE"));
        Date d = rs.getDate("DT_CADASTRO");

        if (d != null) e.setDtCadastro(d.toLocalDate());
        e.setIdCategoria(rs.getInt("ID_CATEGORIA"));
        e.setIdResponsavel(rs.getInt("ID_RESPONSAVEL"));

        return e;
    }
}