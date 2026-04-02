package com.example.ecclesiaapi.controller;

import com.example.ecclesiaapi.domain.Igreja;
import com.example.ecclesiaapi.service.IgrejaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/igrejas")
public class IgrejaController {

    private final IgrejaService igrejaService;

    public IgrejaController(IgrejaService igrejaService) {
        this.igrejaService = igrejaService;
    }

    // ✅ CREATE
    @PostMapping
    public Igreja criar(@RequestBody Igreja igreja) {
        return igrejaService.salvar(igreja, null, null);
    }

    // ✅ UPDATE REAL
    @PutMapping("/{id}")
    public Igreja alterar(@PathVariable Long id,
                          @RequestBody Igreja dados) {

        Igreja igreja = igrejaService.buscarPorId(id);

        if (igreja == null) {
            throw new RuntimeException("Igreja não encontrada");
        }

        igreja.setNome(dados.getNome());
        igreja.setTipo(dados.getTipo());
        igreja.setAtiva(dados.getAtiva());
        igreja.setDiocese(dados.getDiocese());
        igreja.setCep(dados.getCep());
        igreja.setPais(dados.getPais());
        igreja.setEndereco(dados.getEndereco());
        igreja.setNumero(dados.getNumero());
        igreja.setComplemento(dados.getComplemento());
        igreja.setBairro(dados.getBairro());
        igreja.setCidade(dados.getCidade());

        return igrejaService.salvar(igreja, null, null);
    }

    @GetMapping
    public List<Igreja> listar() {
        return igrejaService.listar();
    }
}
