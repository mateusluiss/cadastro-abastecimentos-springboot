package com.desafiojr.desafio_01.services;


import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.desafiojr.desafio_01.DTOs.AbastecimentoDTO;
import com.desafiojr.desafio_01.exceptions.BombaNotFoundException;
import com.desafiojr.desafio_01.mapper.AbastecimentoMapper;
import com.desafiojr.desafio_01.models.Abastecimento;
import com.desafiojr.desafio_01.models.BombaCombustivel;
import com.desafiojr.desafio_01.repositories.BombaRepository;
import com.desafiojr.desafio_01.repositories.AbastecimentoRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AbastecimentoService {
    private final AbastecimentoRepository abastecimentoRepository;
    private final BombaRepository bombaRepository;
    private final AbastecimentoMapper mapper;


    public List<Abastecimento> listarAbastecimentos(){
        return abastecimentoRepository.findAll();
    }

    public Abastecimento listarAbastecimentoPorId(Long id){
        return abastecimentoRepository.findById(id)
            .orElseThrow(() -> new BombaNotFoundException("Abastecimento com ID "+id+" não foi encontrada."));
    }

    public AbastecimentoDTO adicionarAbastecimento(AbastecimentoDTO abastecimentoDto){
        BombaCombustivel bomba = bombaRepository.findById(abastecimentoDto.getBombaId())
            .orElseThrow(() -> new BombaNotFoundException("Abastecimento com ID "+abastecimentoDto.getBombaId()+" não foi encontrada."));
        
        Abastecimento entity = mapper.toEntity(abastecimentoDto);
        entity.setBombaUsada(bomba);
        entity.setValorTotal(bomba.getCombustivel().getPrecoLitro() * entity.getLitragem());
        entity.setDataAbastecimento(LocalDateTime.now());

        Abastecimento save = abastecimentoRepository.save(entity);
        return mapper.toDto(save);
    }

    public void deletarAbastecimento(Long id){
        abastecimentoRepository.findById(id)
            .orElseThrow(() -> new BombaNotFoundException("Abastecimento com ID "+id+" não foi encontrada."));
            
        abastecimentoRepository.deleteById(id);
    }
}
