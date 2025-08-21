package com.desafiojr.desafio_01.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.desafiojr.desafio_01.models.BombaCombustivel;
import com.desafiojr.desafio_01.repository.BombaRepository;
import com.desafiojr.desafio_01.repository.CombustivelRepository;

@Service
public class BombaService {
    private final BombaRepository bombaRepository;


    public BombaService(BombaRepository bombaRepository, CombustivelRepository combustivelRepository){
        this.bombaRepository = bombaRepository;
    }

    public List<BombaCombustivel> listarBombas(){
        return bombaRepository.findAll();
    }

    public Optional<BombaCombustivel> listarBombaPorId(Long id){ //Coloca Optional enquanto não trata as exceções
        return bombaRepository.findById(id);
    }

    public BombaCombustivel adicionarBomba(BombaCombustivel bomba){
        return bombaRepository.save(bomba);
    }

    public void deletarBomba(Long id){
        bombaRepository.deleteById(id);
    }

    public Optional<BombaCombustivel> atualizarBomba(Long id, BombaCombustivel bombaNova){
        return bombaRepository.findById(id)
            .map(bomba -> {
                bomba.setNomeBomba(bombaNova.getNomeBomba());
                bomba.setCombustivel(bombaNova.getCombustivel());
                return bombaRepository.save(bomba);
            });
    }
}
