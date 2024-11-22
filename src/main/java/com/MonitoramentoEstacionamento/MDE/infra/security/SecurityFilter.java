package com.MonitoramentoEstacionamento.MDE.infra.security;


import com.MonitoramentoEstacionamento.MDE.entities.Cliente;
import com.MonitoramentoEstacionamento.MDE.exceptions.UserNotFoundException;
import com.MonitoramentoEstacionamento.MDE.repositories.ClienteRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collections;

@Component
public class SecurityFilter extends OncePerRequestFilter {
    @Autowired
    TokenService tokenService;
    @Autowired
    ClienteRepository clienteRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        var token = this.recoverToken(request);
        var login = tokenService.validateToken(token);

        if (login != null) {
            Cliente cliente = clienteRepository.findByEmail(login)
                    .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

            // aki ce trata como "ROLE_USER" para todos os clientes
            var authorities = Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"));

            // quando eu implementar o adm
            // se o cliente é um administrador (por exemplo, verificando um campo como isAdmin).
            // Exemplo (futuramente):
            // if (cliente.isAdmin()) {
            //    authorities = Collections.singletonList(new SimpleGrantedAuthority("ROLE_ADMIN"));
            // }

            var authentication = new UsernamePasswordAuthenticationToken(cliente, null, authorities);
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        filterChain.doFilter(request, response);
    }

    private String recoverToken(HttpServletRequest request){
        var authHeader = request.getHeader("Authorization");
        if (authHeader == null) {
            logger.warn("Token não enviado na requisição");
            return null;
        }
        return authHeader.replace("Bearer ", "");
    }
}
