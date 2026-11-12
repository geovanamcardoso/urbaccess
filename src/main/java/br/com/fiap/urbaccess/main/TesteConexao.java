package br.com.fiap.urbaccess.main;

import br.com.fiap.urbaccess.conexoes.ConexaoFactory;
import br.com.fiap.urbaccess.excecoes.ExcecoesConexao;

import java.sql.Connection;
import java.sql.SQLException;

public class TesteConexao {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        try{
            Connection conexao = new ConexaoFactory().conexao();

            System.out.println("Conexão estabelecida: " + conexao);

            conexao.close();
        } catch (Exception e) {
            new ExcecoesConexao(e);
        }

    }
}
