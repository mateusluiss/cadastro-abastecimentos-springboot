package com.desafiojr.desafio_01.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.desafiojr.desafio_01.DTOs.CombustivelDTO;
import com.desafiojr.desafio_01.exceptions.CombustivelNotFoundException;
import com.desafiojr.desafio_01.mapper.CombustivelMapper;
import com.desafiojr.desafio_01.models.Combustivel;
import com.desafiojr.desafio_01.repositories.CombustivelRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CombustivelService {
    private final CombustivelRepository combustivelRepository;
    private final CombustivelMapper mapper;


    public List<Combustivel> listarCombustiveis(){
        return combustivelRepository.findAll();
    }

    public Combustivel listarCombustivelPorId(Long id){ //Optional enquanto não trata exceções
        return combustivelRepository.findById(id)
            .orElseThrow(() -> new CombustivelNotFoundException("Combustível com ID "+id+" não foi encontrado."));
    }

    public CombustivelDTO adicionarCombustivel(CombustivelDTO combustivelDto){
        Combustivel entity = mapper.toEntity(combustivelDto);
        
        Combustivel salvo = combustivelRepository.save(entity);
        return mapper.toDto(salvo);
    }

    public void deletarCombustivel(Long id){
        combustivelRepository.findById(id)
            .orElseThrow(() -> new CombustivelNotFoundException("Combustível com ID "+id+" não foi encontrado."));
        
        combustivelRepository.deleteById(id);
    }

    public CombustivelDTO atualizarCombustivel(Long id, CombustivelDTO novoCombustivel){
        Combustivel combustivelAtualizado = combustivelRepository.findById(id)
            .map(combustivel -> {
                combustivel.setNomeCombustivel(novoCombustivel.getNomeCombustivel());
                combustivel.setPrecoLitro(novoCombustivel.getPrecoLitro());
                return combustivelRepository.save(combustivel);
            }).orElseThrow(() -> new CombustivelNotFoundException("Combustível com ID "+id+" não foi encontrado."));
            return mapper.toDto(combustivelAtualizado);
        }

}
