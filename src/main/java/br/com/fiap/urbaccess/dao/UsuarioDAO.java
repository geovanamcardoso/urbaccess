package br.com.fiap.urbaccess.dao;

import br.com.fiap.urbaccess.conexoes.ConexaoFactory;
import br.com.fiap.urbaccess.entities.Usuario;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
    public Connection minhaConexao;

    public UsuarioDAO() throws SQLException, ClassNotFoundException {
        super();
        this.minhaConexao = new ConexaoFactory().conexao();
    }

    public String inserir(Usuario u) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement(
                "INSERT INTO USUARIO (NOME, EMAIL, SENHA_HASH, TIPO_USUARIO, PERFIL_MOBILIDADE, ATIVO, DT_CADASTRO) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?)");

        stmt.setString(1, u.getNome());
        stmt.setString(2, u.getEmail());
        stmt.setString(3, u.getSenhaHash());
        stmt.setString(4, u.getTipoUsuario());
        stmt.setString(5, u.getPerfilMobilidade());
        stmt.setString(6, u.getAtivo() != null ? u.getAtivo() : "S");
        stmt.setDate(7, Date.valueOf(u.getDtCadastro() != null ? u.getDtCadastro() : LocalDate.now()));
        stmt.execute();
        stmt.close();
        minhaConexao.close();
        return "Usuário cadastrado com sucesso!";
    }

    public String deletar(int id) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement(
                "DELETE FROM USUARIO WHERE ID_USUARIO = ?");
        stmt.setInt(1, id);
        stmt.execute();
        stmt.close();
        minhaConexao.close();
        return "Usuário deletado com sucesso!";
    }

    public String atualizar(Usuario u) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement(
                "UPDATE USUARIO SET NOME = ?, TIPO_USUARIO = ?, PERFIL_MOBILIDADE = ?, ATIVO = ? " +
                        "WHERE ID_USUARIO = ?");
        stmt.setString(1, u.getNome());
        stmt.setString(2, u.getTipoUsuario());
        stmt.setString(3, u.getPerfilMobilidade());
        stmt.setString(4, u.getAtivo());
        stmt.setInt(5, u.getIdUsuario());
        stmt.executeUpdate();
        stmt.close();
        minhaConexao.close();
        return "Usuário atualizado com sucesso!";
    }

    public List<Usuario> selecionar() throws SQLException {
        List<Usuario> lista = new ArrayList<>();
        PreparedStatement stmt = minhaConexao.prepareStatement("SELECT * FROM USUARIO");
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Usuario u = new Usuario();
            u.setIdUsuario(rs.getInt("ID_USUARIO"));
            u.setNome(rs.getString("NOME"));
            u.setEmail(rs.getString("EMAIL"));
            u.setSenhaHash(rs.getString("SENHA_HASH"));
            u.setTipoUsuario(rs.getString("TIPO_USUARIO"));
            u.setPerfilMobilidade(rs.getString("PERFIL_MOBILIDADE"));
            u.setAtivo(rs.getString("ATIVO"));
            Date d = rs.getDate("DT_CADASTRO");
            if (d != null) u.setDtCadastro(d.toLocalDate());
            lista.add(u);
        }
        rs.close();
        stmt.close();
        minhaConexao.close();
        return lista;
    }

    public Usuario buscarPorId(int id) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement(
                "SELECT * FROM USUARIO WHERE ID_USUARIO = ?");
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        Usuario u = null;
        if (rs.next()) {
            u = new Usuario();
            u.setIdUsuario(rs.getInt("ID_USUARIO"));
            u.setNome(rs.getString("NOME"));
            u.setEmail(rs.getString("EMAIL"));
            u.setSenhaHash(rs.getString("SENHA_HASH"));
            u.setTipoUsuario(rs.getString("TIPO_USUARIO"));
            u.setPerfilMobilidade(rs.getString("PERFIL_MOBILIDADE"));
            u.setAtivo(rs.getString("ATIVO"));
            Date d = rs.getDate("DT_CADASTRO");
            if (d != null) u.setDtCadastro(d.toLocalDate());
        }
        rs.close();
        stmt.close();
        minhaConexao.close();
        return u;
    }
}

