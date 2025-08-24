package com.desafiojr.desafio_01.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.desafiojr.desafio_01.DTOs.AbastecimentoDTO;
import com.desafiojr.desafio_01.models.Abastecimento;

@Mapper(componentModel = "spring")
public interface AbastecimentoMapper {
    
    @Mapping(source = "bombaUsada.id", target = "bombaId")
    AbastecimentoDTO toDto (Abastecimento entity);

    @Mapping(target = "bombaUsada", ignore = true)
    @Mapping(target = "valorTotal", ignore = true)
    @Mapping(target = "dataAbastecimento", ignore = true)
    Abastecimento toEntity (AbastecimentoDTO dto);
}
