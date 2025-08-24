package com.desafiojr.desafio_01.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AbastecimentoDTO {
    private Long id;
    private Long bombaId;
    private Double litragem;
    
}
