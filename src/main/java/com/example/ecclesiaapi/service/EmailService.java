package com.example.ecclesiaapi.service;

import org.springframework.stereotype.Service;

@Service
public class EmailService {

    public void enviarEmail(String email, String assunto, String mensagem) {
        // POR ENQUANTO: apenas log no console
        System.out.println("=== ENVIO DE EMAIL ===");
        System.out.println("Para: " + email);
        System.out.println("Assunto: " + assunto);
        System.out.println("Mensagem:");
        System.out.println(mensagem);
        System.out.println("=====================");
    }
}