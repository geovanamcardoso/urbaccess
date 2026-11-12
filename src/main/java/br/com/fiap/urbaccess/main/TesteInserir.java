package br.com.fiap.urbaccess.main;

import br.com.fiap.urbaccess.dao.UsuarioDAO;
import br.com.fiap.urbaccess.entities.Usuario;
import java.time.LocalDate;

public class TesteInserir {
    public static void main(String[] args) throws Exception {

        //int idUsuario, String nome, String email, String senhaHash, String tipoUsuario, String perfilMobilidade, String ativo, LocalDate dtCadastro
        Usuario u = new Usuario();
        u.setNome("Talita Oliveira");
        u.setEmail("talita@urbaccess.com");
        u.setSenhaHash("senha123");
        u.setTipoUsuario("CIDADAO");
        u.setPerfilMobilidade("CADEIRANTE");
        u.setAtivo("S");
        u.setDtCadastro(LocalDate.now());

        UsuarioDAO dao = new UsuarioDAO();
        System.out.println(dao.inserir(u));


    }
}