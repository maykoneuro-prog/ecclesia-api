package com.example.ecclesiaapi.service;

import com.example.ecclesiaapi.domain.Igreja;
import com.example.ecclesiaapi.domain.Pessoa;
import com.example.ecclesiaapi.repository.IgrejaRepository;
import com.example.ecclesiaapi.repository.PessoaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IgrejaService {

    private final IgrejaRepository igrejaRepository;
    private final PessoaRepository pessoaRepository;

    public IgrejaService(IgrejaRepository igrejaRepository,
                         PessoaRepository pessoaRepository) {
        this.igrejaRepository = igrejaRepository;
        this.pessoaRepository = pessoaRepository;
    }

    public Igreja salvar(Igreja igreja, Long igrejaPaiId, Long responsavelId) {

        if (igrejaPaiId != null) {
            Igreja pai = igrejaRepository.findById(igrejaPaiId)
                    .orElseThrow(() -> new RuntimeException("Igreja pai não encontrada"));
            igreja.setIgrejaPai(pai);
        }

        if (responsavelId != null) {
            Pessoa responsavel = pessoaRepository.findById(responsavelId)
                    .orElseThrow(() -> new RuntimeException("Responsável não encontrado"));
            igreja.setResponsavel(responsavel);
        }

        return igrejaRepository.save(igreja);
    }

    public List<Igreja> listar() {
        return igrejaRepository.findAll();
    }

    public List<Igreja> listarPorTipo(String tipo) {
        return igrejaRepository.findByTipo(tipo);
    }
}