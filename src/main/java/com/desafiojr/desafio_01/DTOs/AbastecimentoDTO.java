package com.desafiojr.desafio_01.DTOs;




public class AbastecimentoDTO {

    private Long bombaId;
    private Double litragem;

    public Long getBombaId(){
        return bombaId;
    }

    public void setBombaId(Long bombaId) {
        this.bombaId = bombaId;
    }

    public Double getLitragem() {
        return litragem;
    }

    public void setLitragem(Double litragem) {
        this.litragem = litragem;
    }

}
