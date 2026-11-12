package br.com.fiap.urbaccess.controller;

import br.com.fiap.urbaccess.bo.EstabelecimentoBo;
import br.com.fiap.urbaccess.entities.Estabelecimento;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.sql.SQLException;
import java.util.ArrayList;

@RestController
@RequestMapping("/estabelecimento")
public class EstabelecimentoController {

    EstabelecimentoBo estabelecimentoBo = new EstabelecimentoBo();

    @GetMapping
    public ArrayList<Estabelecimento> selecionar()
            throws SQLException, ClassNotFoundException {
        return estabelecimentoBo.selecionarBo();
    }

    @GetMapping("/{id}")
    public Estabelecimento buscarPorId(@PathVariable int id)
            throws SQLException, ClassNotFoundException {
        return estabelecimentoBo.buscarPorIdBo(id);
    }

    @PostMapping
    public ResponseEntity<Void> inserir(@RequestBody Estabelecimento e)
            throws SQLException, ClassNotFoundException {
        estabelecimentoBo.inserirBo(e);
        URI location = URI.create("/estabelecimento/" + e.getIdEstabelecimento());
        return ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<Void> atualizar(@RequestBody Estabelecimento e)
            throws SQLException, ClassNotFoundException {
        estabelecimentoBo.atualizarBo(e);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable int id)
            throws SQLException, ClassNotFoundException {
        estabelecimentoBo.deletarBo(id);
        return ResponseEntity.ok().build();
    }
}