package com.MonitoramentoEstacionamento.MDE.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class ClienteController {
    @GetMapping
    public ResponseEntity<String> getCliente(){
        return ResponseEntity.ok("sucesso!");
    }

    //get dados do usuários
    //put dados do usuários
}
