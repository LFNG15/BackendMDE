package com.MonitoramentoEstacionamento.MDE.entities;
import jakarta.persistence.*;

//a gente vai usar mesmo essa porra?

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer clienteId;

    @Column(nullable = false, length = 50)
    private String nome;

    @Column(nullable = false, length = 14, unique = true)
    private String cpf;

    @Column(length = 15)
    private String telefone;

    @Column(length = 50)
    private String email;

    // Getters e Setters
    public Integer getClienteId() {
        return clienteId;
    }

    public void setClienteId(Integer clienteId) {
        this.clienteId = clienteId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}