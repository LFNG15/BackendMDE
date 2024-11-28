package com.MonitoramentoEstacionamento.MDE.utils;

import java.util.regex.Pattern;

public class CPFUtils {

    public static boolean isValid(String cpf) {
        if (cpf == null || cpf.length() != 11) {
            return false;
        }

        if (cpf.matches("(\\d)\\1{10}")) {
            return false;
        }

        int[] digits = new int[11];
        for (int i = 0; i < 11; i++) {
            digits[i] = Integer.parseInt(String.valueOf(cpf.charAt(i)));
        }

        int sum1 = 0;
        for (int i = 0; i < 9; i++) {
            sum1 += digits[i] * (10 - i);
        }

        int checkDigit1 = (sum1 * 10) % 11;
        if (checkDigit1 == 10) checkDigit1 = 0;

        if (digits[9] != checkDigit1) {
            return false;
        }

        int sum2 = 0;
        for (int i = 0; i < 10; i++) {
            sum2 += digits[i] * (11 - i);
        }

        int checkDigit2 = (sum2 * 10) % 11;
        if (checkDigit2 == 10) checkDigit2 = 0;

        return digits[10] == checkDigit2;
    }
}

