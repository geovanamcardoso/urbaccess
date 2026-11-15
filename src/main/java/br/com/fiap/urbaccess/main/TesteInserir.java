package br.com.fiap.urbaccess.main;

import br.com.fiap.urbaccess.dao.*;
import br.com.fiap.urbaccess.entities.*;
import br.com.fiap.urbaccess.excecoes.ExcecoesConexao;

import java.time.LocalDate;

public class TesteInserir {
    public static void main(String[] args) throws Exception {
        try{
        Usuario u = new Usuario();
        u.setNome("Talita Oliveira");
        u.setEmail("tali@urbaccess.com");
        u.setSenhaHash("senha123");
        u.setTipoUsuario("CIDADAO");
        u.setPerfilMobilidade("CADEIRANTE");
        u.setAtivo("S");
        u.setDtCadastro(LocalDate.now());

        System.out.println(new UsuarioDAO().inserir(u));

        Estabelecimento e = new Estabelecimento();
        e.setNome("Padaria Pão Vivo");
        e.setEndereco("Rua das Flores, 120");
        e.setBairro("Centro");
        e.setCidade("São Paulo");
        e.setUf("SP");
        e.setLatitude(-23.5505);
        e.setLongitude(-46.6333);
        e.setNotaAcessibilidade(9.1);
        e.setDtCadastro(LocalDate.now());
        e.setIdCategoria(1);
        e.setIdResponsavel(0);// sem responsável

        System.out.println(new EstabelecimentoDAO().inserir(e));

        Denuncia d = new Denuncia();
        d.setDescricao("Degrau na entrada sem rampa de acesso.");
        d.setUrlFoto("https://exemplo.com/foto1.jpg");
        d.setLatitude(-23.5505);
        d.setLongitude(-46.6333);
        d.setStatus("ABERTA");
        d.setDtAbertura(LocalDate.now());
        d.setIdUsuario(9);
        d.setIdEstabelecimento(1);
        d.setIdRecurso(1);
        d.setIdModerador(0); // sem moderador

        System.out.println(new DenunciaDAO().inserir(d));

        Avaliacao a = new Avaliacao();
        a.setComentario("Ótimo acesso! Rampa bem conservada.");
        a.setNotaCalculada(9.1);
        a.setDtAvaliacao(LocalDate.now());
        a.setIdUsuario(9);
        a.setIdEstabelecimento(1);

        System.out.println(new AvaliacaoDAO().inserir(a));

        Contestacao c = new Contestacao();
        c.setJustificativa("A rampa foi instalada há duas semanas.");
        c.setStatus("PENDENTE");
        c.setParecerAdmin(null);
        c.setDtContestacao(LocalDate.now());
        c.setDtAnalise(null);
        c.setIdUsuario(9);
        c.setIdDenuncia(1);

        System.out.println(new ContestacaoDAO().inserir(c));

        }catch(Exception e){
            new ExcecoesConexao(e);
        }


    }
}