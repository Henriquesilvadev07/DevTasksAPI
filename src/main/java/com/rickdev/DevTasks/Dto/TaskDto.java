package com.rickdev.DevTasks.Dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.rickdev.DevTasks.Model.StatusEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record TaskDto(@NotBlank(message = "O titulo é obrigatorio") String titulo,
                      @NotBlank(message = "A descricao é obrigatoria") String descricao,
                      @NotNull(message = "O Status é obrigatorio") StatusEnum status,
                      @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime dataCricacao) {
}
