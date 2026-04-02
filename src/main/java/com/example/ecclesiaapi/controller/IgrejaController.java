package com.example.ecclesiaapi.controller;

import com.example.ecclesiaapi.domain.Igreja;
import com.example.ecclesiaapi.service.IgrejaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/igrejas")
@CrossOrigin(origins = "*")
public class IgrejaController {

    private final IgrejaService igrejaService;

    public IgrejaController(IgrejaService igrejaService) {
        this.igrejaService = igrejaService;
    }

    @PostMapping
    public Igreja criar(@RequestBody Igreja igreja) {
        return igrejaService.salvar(igreja);
    }

    @PutMapping("/{id}")
    public Igreja alterar(@PathVariable Long id,
                          @RequestBody Igreja dados) {

        Igreja existente = igrejaService.buscarPorId(id);

        if (existente == null) {
            throw new RuntimeException("Registro não encontrado");
        }

        existente.setNome(dados.getNome());
        existente.setTipo(dados.getTipo());
        existente.setAtiva(dados.getAtiva());
        existente.setDiocese(dados.getDiocese());
        existente.setCep(dados.getCep());
        existente.setEndereco(dados.getEndereco());
        existente.setBairro(dados.getBairro());
        existente.setCidade(dados.getCidade());

        return igrejaService.salvar(existente);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        igrejaService.excluir(id);
    }

    @GetMapping
    public List<Igreja> listar() {
        return igrejaService.listar();
    }
}
