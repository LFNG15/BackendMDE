package com.MonitoramentoEstacionamento.MDE.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequestDTO{
        private String nome;
        private String cpf;
        private String telefone;
        private String email;
        private String password;
}
