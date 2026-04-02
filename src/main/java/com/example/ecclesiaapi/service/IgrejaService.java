package com.example.ecclesiaapi.service;

import com.example.ecclesiaapi.domain.Igreja;
import com.example.ecclesiaapi.repository.IgrejaRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IgrejaService {

    private final IgrejaRepository igrejaRepository;

    public IgrejaService(IgrejaRepository igrejaRepository) {
        this.igrejaRepository = igrejaRepository;
    }

    /* ✅ CREATE / UPDATE */
    @Transactional
    public Igreja salvar(Igreja igreja) {
        return igrejaRepository.save(igreja);
    }

    /* ✅ LIST */
    public List<Igreja> listar() {
        return igrejaRepository.findAll();
    }

    /* ✅ FIND BY ID */
    public Igreja buscarPorId(Long id) {
        return igrejaRepository.findById(id).orElse(null);
    }

    /* ✅ DELETE REAL */
    @Transactional
    public void excluir(Long id) {
        if (!igrejaRepository.existsById(id)) {
            throw new RuntimeException("Registro não encontrado para exclusão");
        }
        igrejaRepository.deleteById(id);
    }
}
