package com.desafiojr.desafio_01.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CombustivelDTO {
    private Long id;
    private String nomeCombustivel;
    private Double precoLitro;
}
