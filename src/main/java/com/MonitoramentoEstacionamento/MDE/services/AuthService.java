package com.MonitoramentoEstacionamento.MDE.services;

import com.MonitoramentoEstacionamento.MDE.dto.LoginRequestDTO;
import com.MonitoramentoEstacionamento.MDE.dto.RegisterRequestDTO;
import com.MonitoramentoEstacionamento.MDE.dto.ResponseDTO;
import com.MonitoramentoEstacionamento.MDE.entities.Cliente;
import com.MonitoramentoEstacionamento.MDE.exceptions.CPFInvalidoException;
import com.MonitoramentoEstacionamento.MDE.exceptions.EmailJaCadastradoException;
import com.MonitoramentoEstacionamento.MDE.exceptions.InvalidCredentialsException;
import com.MonitoramentoEstacionamento.MDE.exceptions.UserNotFoundException;
import com.MonitoramentoEstacionamento.MDE.infra.security.TokenService;
import com.MonitoramentoEstacionamento.MDE.repositories.ClienteRepository;
import com.MonitoramentoEstacionamento.MDE.utils.CPFUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AuthService {
    private final ClienteRepository clienteRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;

    public ResponseDTO login(LoginRequestDTO body) {
        Cliente cliente = clienteRepository.findByEmail(body.email())
                .orElseThrow(() -> new UserNotFoundException("Usuário não encontrado."));

        if (!passwordEncoder.matches(body.password(), cliente.getPassword())) {
            throw new InvalidCredentialsException("Credenciais inválidas.");
        }

        String token = tokenService.generateToken(cliente);
        return new ResponseDTO(cliente.getNome(), token);
    }

    public ResponseDTO register(RegisterRequestDTO body) {
        String normalizedCpf = body.cpf().replaceAll("\\D", "");

        if (normalizedCpf.length() != 11) {
            throw new CPFInvalidoException("CPF deve conter exatamente 11 dígitos.");
        }

        if (clienteRepository.findByEmail(body.email()).isPresent()) {
            throw new EmailJaCadastradoException("E-mail já cadastrado.");
        }

        Cliente newCliente = new Cliente();
        newCliente.setNome(body.nome());
        newCliente.setCpf(body.cpf());
        newCliente.setTelefone(body.telefone());
        newCliente.setEmail(body.email());
        newCliente.setPassword(passwordEncoder.encode(body.password()));

        clienteRepository.save(newCliente);

        return new ResponseDTO(newCliente.getNome(), "Usuário registrado com sucesso. Faça login.");
    }
}

