package com.MonitoramentoEstacionamento.MDE.infra.security;

import com.MonitoramentoEstacionamento.MDE.entities.Cliente;
import com.MonitoramentoEstacionamento.MDE.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
//adicionar ou adaptar o metodo para get dos dados e detalhe do cliente
@Component
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private ClienteRepository repository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Cliente cliente = this.repository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("Usuario não encontrado"));
        return new org.springframework.security.core.userdetails.User(cliente.getEmail(), cliente.getPassword(), new ArrayList<>());
    }
}
