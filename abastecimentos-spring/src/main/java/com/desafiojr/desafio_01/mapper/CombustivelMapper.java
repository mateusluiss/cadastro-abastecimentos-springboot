package com.desafiojr.desafio_01.mapper;

import org.mapstruct.Mapper;

import com.desafiojr.desafio_01.DTOs.CombustivelDTO;
import com.desafiojr.desafio_01.models.Combustivel;

@Mapper(componentModel = "spring")
public interface CombustivelMapper {
    
    CombustivelDTO toDto (Combustivel entity);

    Combustivel toEntity (CombustivelDTO dto);
}
