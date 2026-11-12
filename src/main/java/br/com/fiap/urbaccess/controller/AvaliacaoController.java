package br.com.fiap.urbaccess.controller;

import br.com.fiap.urbaccess.bo.AvaliacaoBo;
import br.com.fiap.urbaccess.entities.Avaliacao;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.sql.SQLException;
import java.util.ArrayList;

@RestController
@RequestMapping("/avaliacao")
public class AvaliacaoController {

    AvaliacaoBo avaliacaoBo = new AvaliacaoBo();

    @GetMapping
    public ArrayList<Avaliacao> selecionar()
            throws SQLException, ClassNotFoundException {
        return avaliacaoBo.selecionarBo();
    }

    @GetMapping("/{id}")
    public Avaliacao buscarPorId(@PathVariable int id)
            throws SQLException, ClassNotFoundException {
        return avaliacaoBo.buscarPorIdBo(id);
    }

    @GetMapping("/estabelecimento/{idEstabelecimento}")
    public ArrayList<Avaliacao> buscarPorEstabelecimento(
            @PathVariable int idEstabelecimento)
            throws SQLException, ClassNotFoundException {
        return avaliacaoBo.buscarPorEstabelecimentoBo(idEstabelecimento);
    }

    @PostMapping
    public ResponseEntity<Void> inserir(@RequestBody Avaliacao a)
            throws SQLException, ClassNotFoundException {
        avaliacaoBo.inserirBo(a);
        URI location = URI.create("/avaliacao/" + a.getIdAvaliacao());
        return ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<Void> atualizar(@RequestBody Avaliacao a)
            throws SQLException, ClassNotFoundException {
        avaliacaoBo.atualizarBo(a);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable int id)
            throws SQLException, ClassNotFoundException {
        avaliacaoBo.deletarBo(id);
        return ResponseEntity.ok().build();
    }
}