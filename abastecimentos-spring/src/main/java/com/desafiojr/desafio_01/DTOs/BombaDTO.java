package com.desafiojr.desafio_01.DTOs;

import com.desafiojr.desafio_01.models.Combustivel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BombaDTO {
    private Long id;
    private String nomeBomba;
    private Combustivel combustivel;
}
