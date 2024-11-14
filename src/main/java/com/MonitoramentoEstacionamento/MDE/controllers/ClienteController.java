package com.MonitoramentoEstacionamento.MDE.controllers;

import com.MonitoramentoEstacionamento.MDE.dto.LoginRequestDTO;
import com.MonitoramentoEstacionamento.MDE.dto.LoginResponseDTO;
import com.MonitoramentoEstacionamento.MDE.entities.Cliente;
import com.MonitoramentoEstacionamento.MDE.services.ClienteService;
import com.MonitoramentoEstacionamento.MDE.services.TokenService;
import com.MonitoramentoEstacionamento.MDE.security.SecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping
    public List<Cliente> listarClientes() {
        return clienteService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarCliente(@PathVariable Integer id) {
        return ResponseEntity.of(clienteService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Cliente> criarCliente(@RequestBody Cliente cliente) {
        cliente.setPassword(passwordEncoder.encode(cliente.getPassword()));

        Cliente clienteSalvo = clienteService.save(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteSalvo);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginCliente(@RequestBody LoginRequestDTO loginRequest) {
        boolean isAuthenticated = clienteService.authenticate(loginRequest.getUsername(), loginRequest.getPassword());

        if (isAuthenticated) {
            String token = tokenService.generateToken(loginRequest.getUsername());
            return ResponseEntity.ok(new LoginResponseDTO(token));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciais inválidas");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizarCliente(@PathVariable Integer id, @RequestBody Cliente cliente) {
        return ResponseEntity.of(clienteService.update(id, cliente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCliente(@PathVariable Integer id) {
        clienteService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
