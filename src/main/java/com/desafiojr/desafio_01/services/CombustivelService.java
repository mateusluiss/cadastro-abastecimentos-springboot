package com.desafiojr.desafio_01.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.desafiojr.desafio_01.exceptions.CombustivelNotFoundException;
import com.desafiojr.desafio_01.models.Combustivel;
import com.desafiojr.desafio_01.repositories.CombustivelRepository;

@Service
public class CombustivelService {
    private final CombustivelRepository combustivelRepository;

    public CombustivelService(CombustivelRepository combustivelRepository){
        this.combustivelRepository = combustivelRepository;
    }

    public List<Combustivel> listarCombustiveis(){
        return combustivelRepository.findAll();
    }

    public Combustivel listarCombustivelPorId(Long id){ //Optional enquanto não trata exceções
        return combustivelRepository.findById(id)
            .orElseThrow(() -> new CombustivelNotFoundException("Combustível com ID "+id+" não foi encontrado."));
    }

    public Combustivel adicionarCombustivel(Combustivel combustivel){
        return combustivelRepository.save(combustivel);
    }

    public void deletarCombustivel(Long id){
        combustivelRepository.findById(id)
            .orElseThrow(() -> new CombustivelNotFoundException("Combustível com ID "+id+" não foi encontrado."));
        
        combustivelRepository.deleteById(id);
    }

    public Combustivel atualizarCombustivel(Long id, Combustivel novoCombustivel){
        return combustivelRepository.findById(id)
        .map(combustivel -> {
            combustivel.setNomeCombustivel(novoCombustivel.getNomeCombustivel());
            combustivel.setPrecoLitro(novoCombustivel.getPrecoLitro());
            return combustivelRepository.save(combustivel);
        }).orElseThrow(() -> new CombustivelNotFoundException("Combustível com ID "+id+" não foi encontrado."));
    }

}
