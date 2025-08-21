package com.desafiojr.desafio_01.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.desafiojr.desafio_01.models.BombaCombustivel;
import com.desafiojr.desafio_01.repository.BombaRepository;

@Service
public class BombaService {
    private final BombaRepository bombaRepository;

    public BombaService(BombaRepository bombaRepository){
        this.bombaRepository = bombaRepository;
    }

    public List<BombaCombustivel> listarBombas(){
        return bombaRepository.findAll();
    }

    public Optional<BombaCombustivel> listarBombaPorId(Long id){ //Coloca Optional enquanto não trata as exceções
        return bombaRepository.findById(id);
    }
}
