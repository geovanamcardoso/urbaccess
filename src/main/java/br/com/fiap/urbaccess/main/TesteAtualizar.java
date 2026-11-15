package br.com.fiap.urbaccess.main;

import br.com.fiap.urbaccess.dao.*;
import br.com.fiap.urbaccess.entities.*;
import br.com.fiap.urbaccess.excecoes.ExcecoesConexao;
import java.time.LocalDate;

public class TesteAtualizar {
    public static void main(String[] args) {
        try {

            Usuario u = new Usuario();
            u.setIdUsuario(9);
            u.setNome("Talita Oliveira Atualizada");
            u.setTipoUsuario("ADMIN");
            u.setPerfilMobilidade("VISUAL");
            u.setAtivo("S");
            System.out.println(new UsuarioDAO().atualizar(u));

            Estabelecimento e = new Estabelecimento();
            e.setIdEstabelecimento(1);
            e.setNome("Padaria Pão Vivo Atualizada");
            e.setEndereco("Rua das Flores, 150");
            e.setBairro("Centro");
            e.setCidade("São Paulo");
            e.setUf("SP");
            e.setLatitude(-23.5510);
            e.setLongitude(-46.6340);
            e.setIdCategoria(1);
            System.out.println(new EstabelecimentoDAO().atualizar(e));

            Denuncia d = new Denuncia();
            d.setIdDenuncia(1);
            d.setDescricao("Degrau corrigido parcialmente.");
            d.setUrlFoto("https://exemplo.com/foto2.jpg");
            d.setStatus("EM_PRAZO");
            d.setDtPrazo(LocalDate.now().plusDays(10));
            d.setIdModerador(9);
            System.out.println(new DenunciaDAO().atualizar(d));

            Avaliacao a = new Avaliacao();
            a.setIdAvaliacao(1);
            a.setComentario("Acesso bom, mas calçada estreita na lateral.");
            a.setNotaCalculada(7.5);
            System.out.println(new AvaliacaoDAO().atualizar(a));

            Contestacao c = new Contestacao();
            c.setIdContestacao(1);
            c.setStatus("ACEITA");
            c.setParecerAdmin("Correção confirmada por inspeção.");
            c.setDtAnalise(LocalDate.now());
            System.out.println(new ContestacaoDAO().atualizar(c));

        } catch (Exception e) {
            new ExcecoesConexao(e);
        }
    }
}