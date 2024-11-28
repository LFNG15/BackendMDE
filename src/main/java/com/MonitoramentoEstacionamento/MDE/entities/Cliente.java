package com.MonitoramentoEstacionamento.MDE.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "clienteId")
@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long clienteId;

    @Column(nullable = false, length = 50)
    private String nome;

    @Column(nullable = false, length = 11, unique = true)
    private String cpf;

    @Column(length = 15)
    private String telefone;

    @Column(nullable = false, length = 50, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

}
