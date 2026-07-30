package com.rickdev.DevTasks.Exceptions;

import org.springframework.validation.FieldError;

public record DadosValidacao(String campo, String mensagem) {
    public DadosValidacao(FieldError erro) {
        this(erro.getField(),
                erro.getDefaultMessage());
    }
}
