package com.rickdev.DevTasks.Exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TaskException {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity erro404(RuntimeException exception){
        return ResponseEntity.status(404).body(exception.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity erro400(MethodArgumentNotValidException exception) {
        var erros = exception.getFieldErrors()
                .stream()
                .map(DadosValidacao :: new)
                .toList();
        return ResponseEntity.status(400).body(erros);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity erro400Json(HttpMessageNotReadableException exception){
        return ResponseEntity.status(400).body("Erro ao receber dados via Json, verificar dados novamente");
    }
}
