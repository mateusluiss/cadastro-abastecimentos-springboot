package com.desafiojr.desafio_01.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.desafiojr.desafio_01.models.Abastecimento;

@Repository
public interface AbastecimentoRepository extends JpaRepository<Abastecimento, Long> {
    
}
