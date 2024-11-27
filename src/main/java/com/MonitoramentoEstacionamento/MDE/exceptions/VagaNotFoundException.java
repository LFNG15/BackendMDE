package com.MonitoramentoEstacionamento.MDE.exceptions;

public class VagaNotFoundException extends RuntimeException {
    public VagaNotFoundException(String message) {
        super(message);
    }
}