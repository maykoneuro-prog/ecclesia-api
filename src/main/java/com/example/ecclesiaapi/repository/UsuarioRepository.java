package com.example.ecclesiaapi.repository;

import com.example.ecclesiaapi.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    boolean existsByEmail(String email);

    Optional<Usuario> findByEmail(String email);

    List<Usuario> findByAprovadoFalse();

    List<Usuario> findByNomeContainingIgnoreCaseOrEmailContainingIgnoreCase(
            String nome,
            String email
    );
}