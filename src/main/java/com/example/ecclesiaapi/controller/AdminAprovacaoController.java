package com.example.ecclesiaapi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminAprovacaoController {

    @GetMapping("/admin/aprovacoes")
    public String telaAprovacoes() {
        return "admin-aprovacoes"; // ⬅ NÃO colocar .html
    }
}
