package com.example.ecclesiaapi.repository;

import com.example.ecclesiaapi.domain.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}