package com.MonitoramentoEstacionamento.MDE.utils;

import java.util.regex.Pattern;

public class CPFUtils {
    public static String normalizeCPF(String cpf) {
        if (cpf == null) {
            return null;
        }
        return cpf.replaceAll("[^0-9]", "");
    }
}
