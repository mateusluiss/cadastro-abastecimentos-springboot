package com.desafiojr.desafio_01.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.desafiojr.desafio_01.models.Combustivel;
import com.desafiojr.desafio_01.repository.CombustivelRepository;

@Service
public class CombustivelService {
    private final CombustivelRepository combustivelRepository;

    public CombustivelService(CombustivelRepository combustivelRepository){
        this.combustivelRepository = combustivelRepository;
    }

    public List<Combustivel> listarCombustiveis(){
        return combustivelRepository.findAll();
    }

    public Optional<Combustivel> listarCombustivelPorId(Long id){ //Optional enquanto não trata exceções
        return combustivelRepository.findById(id);
    }

    public Combustivel adicionarCombustivel(Combustivel combustivel){
        return combustivelRepository.save(combustivel);
    }

    public void deletarCombustivel(Long id){
        combustivelRepository.deleteById(id);
    }

    public Optional<Combustivel> atualizarCombustivel(Long id, Combustivel novoCombustivel){
        return combustivelRepository.findById(id)
        .map(combustivel -> {
            combustivel.setNomeCombustivel(novoCombustivel.getNomeCombustivel());
            combustivel.setPrecoLitro(novoCombustivel.getPrecoLitro());
            return combustivelRepository.save(combustivel);
        });
    }

}
