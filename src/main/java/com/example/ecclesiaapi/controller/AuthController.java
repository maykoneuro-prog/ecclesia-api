package com.example.ecclesiaapi.controller;

import com.example.ecclesiaapi.domain.Usuario;
import com.example.ecclesiaapi.service.UsuarioService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UsuarioService usuarioService;

    public AuthController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/login")
    public Usuario login(@RequestBody LoginRequest request) {

        // 🔎 LOG DE DIAGNÓSTICO (TEMPORÁRIO)
        System.out.println("LOGIN RECEBIDO:");
        System.out.println("Email = [" + request.getEmail() + "]");
        System.out.println("Senha = [" + request.getSenha() + "]");

        return usuarioService.login(
                request.getEmail(),
                request.getSenha()
        );
    }
}