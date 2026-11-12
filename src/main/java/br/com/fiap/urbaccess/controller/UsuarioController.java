package br.com.fiap.urbaccess.controller;

import br.com.fiap.urbaccess.bo.UsuarioBo;
import br.com.fiap.urbaccess.entities.Usuario;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.sql.SQLException;
import java.util.ArrayList;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    UsuarioBo usuarioBo = new UsuarioBo();

    @GetMapping
    public ArrayList<Usuario> selecionar() throws SQLException, ClassNotFoundException {
        return usuarioBo.selecionarBo();
    }

    @GetMapping("/{id}")
    public Usuario buscarPorId(@PathVariable int id) throws SQLException, ClassNotFoundException {
        return usuarioBo.buscarPorIdBo(id);
    }

    @PostMapping
    public ResponseEntity<Void> inserir(@RequestBody Usuario u) throws SQLException, ClassNotFoundException {
        usuarioBo.inserirBo(u);
        URI location = URI.create("/usuario/" + u.getIdUsuario());
        return ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<Void> atualizar(@RequestBody Usuario u) throws SQLException, ClassNotFoundException {
        usuarioBo.atualizarBo(u);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable int id) throws SQLException, ClassNotFoundException {
        usuarioBo.deletarBo(id);
        return ResponseEntity.ok().build();
    }
}