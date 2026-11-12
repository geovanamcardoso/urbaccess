package br.com.fiap.urbaccess.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(SQLException.class)
    public ResponseEntity<Map<String, String>> handleSQLException(SQLException e) {
        Map<String, String> erro = new HashMap<>();
        erro.put("erro", "Erro no banco de dados!");
        erro.put("detalhes", e.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(erro);
    }

    @ExceptionHandler(ClassNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleClassNotFoundException(ClassNotFoundException e) {
        Map<String, String> erro = new HashMap<>();
        erro.put("erro", "Driver do banco não encontrado!");
        erro.put("detalhes", e.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(erro);
    }

    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<Map<String, String>> handleIllegalState(IllegalStateException e) {
        Map<String, String> erro = new HashMap<>();
        erro.put("erro", "Variáveis de ambiente não configuradas!");
        erro.put("detalhes", e.getMessage());
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(erro);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, String>> handleGeneric(Exception e) {
        Map<String, String> erro = new HashMap<>();
        erro.put("erro", "Erro interno!");
        erro.put("detalhes", e.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(erro);
    }
}