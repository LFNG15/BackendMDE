package com.MonitoramentoEstacionamento.MDE.controllers;

import com.MonitoramentoEstacionamento.MDE.entities.Andar;
import com.MonitoramentoEstacionamento.MDE.repositories.AndarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/andares")
public class AndarController {

    @Autowired
    private AndarRepository andarRepository;

    @GetMapping
    public ResponseEntity<List<Andar>> listarAndares() {
        List<Andar> andares = andarRepository.findAll();
        return ResponseEntity.ok(andares);
    }
}

