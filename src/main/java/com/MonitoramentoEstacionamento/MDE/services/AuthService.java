package com.MonitoramentoEstacionamento.MDE.services;

import com.MonitoramentoEstacionamento.MDE.entities.Cliente;
import com.MonitoramentoEstacionamento.MDE.dto.LoginRequestDTO;
import com.MonitoramentoEstacionamento.MDE.dto.RegisterRequestDTO;
import com.MonitoramentoEstacionamento.MDE.dto.ResponseDTO;
import com.MonitoramentoEstacionamento.MDE.exceptions.EmailJaCadastradoException;
import com.MonitoramentoEstacionamento.MDE.infra.security.TokenService;
import com.MonitoramentoEstacionamento.MDE.repositories.ClienteRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    private final ClienteRepository clienteRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;

    public AuthService(ClienteRepository clienteRepository, PasswordEncoder passwordEncoder, TokenService tokenService) {
        this.clienteRepository = clienteRepository;
        this.passwordEncoder = passwordEncoder;
        this.tokenService = tokenService;
    }

    public ResponseDTO login(LoginRequestDTO body) {
        Cliente cliente = this.clienteRepository.findByEmail(body.email()).orElseThrow(() -> new RuntimeException("User not found"));
        if(passwordEncoder.matches(body.password(), cliente.getPassword())) {
            String token = this.tokenService.generateToken(cliente);
            return new ResponseDTO(cliente.getNome(), token);
        }
        throw new RuntimeException("Invalid credentials");
    }

    public ResponseDTO register(RegisterRequestDTO body) {
        Optional<Cliente> user = this.clienteRepository.findByEmail(body.getEmail());

        if (user.isPresent()) {
            throw new EmailJaCadastradoException("O email já está em uso");
        }

        Cliente newCliente = new Cliente();
        newCliente.setPassword(passwordEncoder.encode(body.getPassword()));
        newCliente.setEmail(body.getEmail());
        newCliente.setNome(body.getNome());
        this.clienteRepository.save(newCliente);

        String token = this.tokenService.generateToken(newCliente);
        return new ResponseDTO(newCliente.getNome(), token);
    }
}
