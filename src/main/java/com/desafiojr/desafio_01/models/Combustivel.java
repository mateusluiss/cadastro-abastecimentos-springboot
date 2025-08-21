package com.desafiojr.desafio_01.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "combustivel")
public class Combustivel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_combustivel")
    @NotNull
    private String nomeCombustivel;

    @Column(name = "preco_por_litro")
    @NotNull
    private Double precoLitro;

    public Combustivel(){

    }

    public Combustivel(String nomeCombustivel, Double precoLitro){
        this.nomeCombustivel = nomeCombustivel;
        this.precoLitro = precoLitro;
    }

    public Long getId() {
        return id;
    }

    public String getNomeCombustivel() {
        return nomeCombustivel;
    }

    public void setNomeCombustivel(String nomeCombustivel) {
        this.nomeCombustivel = nomeCombustivel;
    }

    public Double getPrecoLitro() {
        return precoLitro;
    }

    public void setPrecoLitro(Double precoLitro) {
        this.precoLitro = precoLitro;
    }


}
