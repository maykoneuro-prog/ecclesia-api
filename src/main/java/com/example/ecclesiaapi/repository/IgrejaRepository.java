package com.example.ecclesiaapi.repository;

import com.example.ecclesiaapi.domain.Igreja;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IgrejaRepository extends JpaRepository<Igreja, Long> {

    List<Igreja> findByTipo(String tipo);
}