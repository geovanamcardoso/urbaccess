package br.com.fiap.urbaccess.controller;

import br.com.fiap.urbaccess.bo.DenunciaBo;
import br.com.fiap.urbaccess.entities.Denuncia;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.sql.SQLException;
import java.util.ArrayList;

@RestController
@RequestMapping("/denuncia")
public class DenunciaController {

    DenunciaBo denunciaBo = new DenunciaBo();

    @GetMapping
    public ArrayList<Denuncia> selecionar()
            throws SQLException, ClassNotFoundException {
        return denunciaBo.selecionarBo();
    }

    @GetMapping("/{id}")
    public Denuncia buscarPorId(@PathVariable int id)
            throws SQLException, ClassNotFoundException {
        return denunciaBo.buscarPorIdBo(id);
    }

    @PostMapping
    public ResponseEntity<Void> inserir(@RequestBody Denuncia d)
            throws SQLException, ClassNotFoundException {
        denunciaBo.inserirBo(d);
        URI location = URI.create("/denuncia/" + d.getIdDenuncia());
        return ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<Void> atualizar(@RequestBody Denuncia d)
            throws SQLException, ClassNotFoundException {
        denunciaBo.atualizarBo(d);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<Void> atualizarStatus(
            @PathVariable int id,
            @RequestParam String status)
            throws SQLException, ClassNotFoundException {
        denunciaBo.atualizarStatusBo(id, status);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable int id)
            throws SQLException, ClassNotFoundException {
        denunciaBo.deletarBo(id);
        return ResponseEntity.ok().build();
    }
}