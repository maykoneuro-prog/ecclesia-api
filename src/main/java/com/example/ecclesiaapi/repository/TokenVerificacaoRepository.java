package com.example.ecclesiaapi.repository;

import com.example.ecclesiaapi.domain.TokenVerificacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TokenVerificacaoRepository extends JpaRepository<TokenVerificacao, Long> {

    Optional<TokenVerificacao> findByToken(String token);
}