package com.MonitoramentoEstacionamento.MDE.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record RegisterRequestDTO(
        @NotBlank(message = "Nome é obrigatório.")
        String nome,

        @NotBlank(message = "CPF é obrigatório.")
        @Size(min = 11, max = 11, message = "CPF deve ter 11 dígitos.")
        String cpf,

        @NotBlank(message = "Telefone é obrigatório.")
        String telefone,

        @Email(message = "E-mail inválido.")
        @NotBlank(message = "E-mail é obrigatório.")
        String email,

        @NotBlank(message = "Senha é obrigatória.")
        @Size(min = 6, message = "Senha deve ter pelo menos 6 caracteres.")
        String password
) {}

