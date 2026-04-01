package com.example.ecclesiaapi.controller;

import com.example.ecclesiaapi.domain.Pessoa;
import com.example.ecclesiaapi.dto.PessoaRequest;
import com.example.ecclesiaapi.dto.PessoaResponse;
import com.example.ecclesiaapi.service.PessoaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    private final PessoaService pessoaService;

    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @GetMapping
    public List<PessoaResponse> listar() {
        return pessoaService.listarTodas();
    }

    @PostMapping
    public Pessoa salvar(@RequestBody PessoaRequest request) {
        return pessoaService.salvar(request);
    }
}