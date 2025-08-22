package com.desafiojr.desafio_01.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.desafiojr.desafio_01.models.Abastecimento;
import com.desafiojr.desafio_01.repository.AbastecimentoRepository;

@Service
public class AbastecimentoService {
    private final AbastecimentoRepository abastecimentoRepository;

    public AbastecimentoService(AbastecimentoRepository abastecimentoRepository){
        this.abastecimentoRepository = abastecimentoRepository;
    }

    public List<Abastecimento> listarAbastecimentos(){
        return abastecimentoRepository.findAll();
    }

    public Abastecimento listarAbastecimentoPorId(Long id){
        return abastecimentoRepository.findById(id)
            .orElseThrow();
    }

    public Abastecimento adicionarAbastecimento(Abastecimento abastecimento){
        return abastecimentoRepository.save(abastecimento);
    }

    public void deletarAbastecimento(Long id){
        abastecimentoRepository.deleteById(id);
    }
}
