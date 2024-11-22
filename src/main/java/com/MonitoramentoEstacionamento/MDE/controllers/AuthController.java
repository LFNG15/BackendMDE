package com.MonitoramentoEstacionamento.MDE.controllers;

import com.MonitoramentoEstacionamento.MDE.dto.LoginRequestDTO;
import com.MonitoramentoEstacionamento.MDE.dto.RegisterRequestDTO;
import com.MonitoramentoEstacionamento.MDE.dto.ResponseDTO;
import com.MonitoramentoEstacionamento.MDE.services.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<ResponseDTO> login(@RequestBody @Valid LoginRequestDTO body) {
        ResponseDTO response = authService.login(body);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping("/register")
    public ResponseEntity<ResponseDTO> register(@RequestBody @Valid RegisterRequestDTO body) {
        ResponseDTO response = authService.register(body);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
