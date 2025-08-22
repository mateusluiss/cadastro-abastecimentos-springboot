package com.desafiojr.desafio_01.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafiojr.desafio_01.models.Abastecimento;

public interface AbastecimentoRepository extends JpaRepository<Abastecimento, Long> {
    
}
