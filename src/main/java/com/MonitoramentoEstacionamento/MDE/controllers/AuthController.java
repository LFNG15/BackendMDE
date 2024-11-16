package com.MonitoramentoEstacionamento.MDE.controllers;

import com.MonitoramentoEstacionamento.MDE.dto.LoginRequestDTO;
import com.MonitoramentoEstacionamento.MDE.entities.Cliente;
import com.MonitoramentoEstacionamento.MDE.repositories.ClienteRepository;
import com.MonitoramentoEstacionamento.MDE.infra.security.TokenService;
import com.MonitoramentoEstacionamento.MDE.dto.ResponseDTO;
import com.MonitoramentoEstacionamento.MDE.dto.RegisterRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final ClienteRepository clienteRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginRequestDTO body){
        Cliente cliente = this.clienteRepository.findByEmail(body.email()).orElseThrow(() -> new RuntimeException("User not found"));
        if(passwordEncoder.matches(cliente.getPassword(), body.password())) {
            String token = this.tokenService.generateToken(cliente);
            return ResponseEntity.ok(new ResponseDTO(cliente.getNome(), token));
        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody RegisterRequestDTO body){
        Optional<Cliente> cliente = this.clienteRepository.findByEmail(body.email());

        if(cliente.isEmpty()) {
            Cliente newCliente = new Cliente();
            newCliente.setPassword(passwordEncoder.encode(body.password()));
            newCliente.setNome(body.nome());
            newCliente.setCpf(body.cpf());
            newCliente.setTelefone(body.telefone());
            newCliente.setEmail(body.email());
            this.clienteRepository.save(newCliente);

            String token = this.tokenService.generateToken(newCliente);
            return ResponseEntity.ok(new ResponseDTO(newCliente.getNome(), token));
        }
        return ResponseEntity.badRequest().build();
    }
}
