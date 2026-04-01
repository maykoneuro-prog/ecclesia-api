package com.example.ecclesiaapi.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordUtil {

    private static final BCryptPasswordEncoder encoder =
            new BCryptPasswordEncoder();

    // Gera hash seguro
    public static String gerarHash(String senha) {
        return encoder.encode(senha);
    }

    // Valida senha digitada
    public static boolean validar(String senhaDigitada, String hashSalvo) {
        return encoder.matches(senhaDigitada, hashSalvo);
    }
}