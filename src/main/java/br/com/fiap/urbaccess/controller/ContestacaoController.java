package br.com.fiap.urbaccess.controller;

import br.com.fiap.urbaccess.bo.ContestacaoBo;
import br.com.fiap.urbaccess.entities.Contestacao;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.sql.SQLException;
import java.util.ArrayList;

@RestController
@RequestMapping("/contestacao")
public class ContestacaoController {

    ContestacaoBo contestacaoBo = new ContestacaoBo();

    @GetMapping
    public ArrayList<Contestacao> selecionar()
            throws SQLException, ClassNotFoundException {
        return contestacaoBo.selecionarBo();
    }

    @GetMapping("/{id}")
    public Contestacao buscarPorId(@PathVariable int id)
            throws SQLException, ClassNotFoundException {
        return contestacaoBo.buscarPorIdBo(id);
    }

    @GetMapping("/denuncia/{idDenuncia}")
    public ArrayList<Contestacao> buscarPorDenuncia(
            @PathVariable int idDenuncia)
            throws SQLException, ClassNotFoundException {
        return contestacaoBo.buscarPorDenunciaBo(idDenuncia);
    }

    @PostMapping
    public ResponseEntity<Void> inserir(@RequestBody Contestacao c)
            throws SQLException, ClassNotFoundException {
        contestacaoBo.inserirBo(c);
        URI location = URI.create("/contestacao/" + c.getIdContestacao());
        return ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<Void> atualizar(@RequestBody Contestacao c)
            throws SQLException, ClassNotFoundException {
        contestacaoBo.atualizarBo(c);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable int id)
            throws SQLException, ClassNotFoundException {
        contestacaoBo.deletarBo(id);
        return ResponseEntity.ok().build();
    }
}