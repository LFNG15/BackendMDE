package com.MonitoramentoEstacionamento.MDE.dto;

public class LoginResponseDTO {

    private String token;

    // Construtor
    public LoginResponseDTO() {}

    public LoginResponseDTO(String token) {
        this.token = token;
    }

    // Getter e Setter
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
