package com.desafiojr.desafio_01.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.desafiojr.desafio_01.models.Combustivel;

@Repository
public interface CombustivelRepository extends JpaRepository<Combustivel, Long> {
    
}
