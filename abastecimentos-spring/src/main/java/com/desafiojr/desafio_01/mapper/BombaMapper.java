package com.desafiojr.desafio_01.mapper;

import org.mapstruct.Mapper;

import com.desafiojr.desafio_01.DTOs.BombaDTO;
import com.desafiojr.desafio_01.models.BombaCombustivel;

@Mapper(componentModel = "spring")
public interface BombaMapper {
    BombaDTO toDto (BombaCombustivel entity);

    BombaCombustivel toEntity (BombaDTO dto);
}
