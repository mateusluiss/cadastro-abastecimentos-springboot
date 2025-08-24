package com.desafiojr.desafio_01.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.desafiojr.desafio_01.DTOs.BombaDTO;
import com.desafiojr.desafio_01.exceptions.BombaNotFoundException;
import com.desafiojr.desafio_01.mapper.BombaMapper;
import com.desafiojr.desafio_01.models.BombaCombustivel;
import com.desafiojr.desafio_01.repositories.BombaRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BombaService {
    private final BombaRepository bombaRepository;
    private final BombaMapper mapper;

    public List<BombaCombustivel> listarBombas(){
        return bombaRepository.findAll();
    }

    public BombaCombustivel listarBombaPorId(Long id){ //Coloca Optional enquanto não trata as exceções
        return bombaRepository.findById(id)
            .orElseThrow(() -> new BombaNotFoundException("Bomba com ID "+id+" não foi encontrada."));
    }

    public BombaDTO adicionarBomba(BombaDTO bomba){
        BombaCombustivel entity = mapper.toEntity(bomba);

        BombaCombustivel salvo = bombaRepository.save(entity);
        return mapper.toDto(salvo);
    }

    public void deletarBomba(Long id){
        bombaRepository.findById(id)
            .orElseThrow(() -> new BombaNotFoundException("Bomba com ID "+id+" não foi encontrada."));
        
        bombaRepository.deleteById(id);
    }

    public BombaDTO atualizarBomba(Long id, BombaDTO bombaNova){
        BombaCombustivel bombaAtualizada = bombaRepository.findById(id)
            .map(bomba -> {
                bomba.setNomeBomba(bombaNova.getNomeBomba());
                bomba.setCombustivel(bombaNova.getCombustivel());
                return bombaRepository.save(bomba);
            }).orElseThrow(() -> new BombaNotFoundException("Bomba com ID "+id+" não foi encontrada."));
            
            return mapper.toDto(bombaAtualizada);
        }

}
