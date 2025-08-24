package com.desafiojr.desafio_01.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.desafiojr.desafio_01.exceptions.BombaNotFoundException;
import com.desafiojr.desafio_01.models.BombaCombustivel;
import com.desafiojr.desafio_01.repositories.BombaRepository;
import com.desafiojr.desafio_01.repositories.CombustivelRepository;

@Service
public class BombaService {
    private final BombaRepository bombaRepository;


    public BombaService(BombaRepository bombaRepository, CombustivelRepository combustivelRepository){
        this.bombaRepository = bombaRepository;
    }

    public List<BombaCombustivel> listarBombas(){
        return bombaRepository.findAll();
    }

    public BombaCombustivel listarBombaPorId(Long id){ //Coloca Optional enquanto não trata as exceções
        return bombaRepository.findById(id)
            .orElseThrow(() -> new BombaNotFoundException("Bomba com ID "+id+" não foi encontrada."));
    }

    public BombaCombustivel adicionarBomba(BombaCombustivel bomba){
        return bombaRepository.save(bomba);
    }

    public void deletarBomba(Long id){
        bombaRepository.findById(id)
            .orElseThrow(() -> new BombaNotFoundException("Bomba com ID "+id+" não foi encontrada."));
        
        bombaRepository.deleteById(id);
    }

    public BombaCombustivel atualizarBomba(Long id, BombaCombustivel bombaNova){
        return bombaRepository.findById(id)
            .map(bomba -> {
                bomba.setNomeBomba(bombaNova.getNomeBomba());
                bomba.setCombustivel(bombaNova.getCombustivel());
                return bombaRepository.save(bomba);
            }).orElseThrow(() -> new BombaNotFoundException("Bomba com ID "+id+" não foi encontrada."));
    }
}
