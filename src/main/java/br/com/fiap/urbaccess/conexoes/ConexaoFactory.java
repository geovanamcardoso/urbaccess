package br.com.fiap.urbaccess.conexoes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactory {


    private static final String URL = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl";

    public Connection conexao() throws ClassNotFoundException, SQLException {
        String usuario = System.getenv("DB_USUARIO");
        String senha = System.getenv("DB_SENHA");

        if (usuario == null || usuario.isBlank() || senha == null || senha.isBlank()) {
            throw new IllegalStateException(
                    "Configure as variáveis de ambiente DB_USUARIO e DB_SENHA antes de rodar");
        }

        // Driver
        Class.forName("oracle.jdbc.driver.OracleDriver");
        // Retorna a conexao
        return DriverManager.getConnection(URL, usuario, senha);
    }
}