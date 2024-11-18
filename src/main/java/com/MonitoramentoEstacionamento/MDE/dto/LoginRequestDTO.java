package com.MonitoramentoEstacionamento.MDE.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record LoginRequestDTO(
        @Email(message = "E-mail inválido.")
        @NotBlank(message = "E-mail é obrigatório.")
        String email,

        @NotBlank(message = "Senha é obrigatória.")
        @Size(min = 6, message = "Senha deve ter pelo menos 6 caracteres.")
        String password
) {}