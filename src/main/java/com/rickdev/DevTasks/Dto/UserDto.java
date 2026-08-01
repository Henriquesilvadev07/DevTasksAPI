package com.rickdev.DevTasks.Dto;

import jakarta.validation.constraints.NotBlank;

public record UserDto (@NotBlank(message = "É Obrigatiorio inserir um login") String login,
                       @NotBlank(message = "É Obrigatório inserir uma senha") String senha){
}
