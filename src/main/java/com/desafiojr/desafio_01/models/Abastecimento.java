package com.desafiojr.desafio_01.models;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "abastecimento")
@EntityListeners(AuditingEntityListener.class)
public class Abastecimento {
    //FK -> Bomba (BombasCombustível), Quantidade em valores e litragem(Abastecimento)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "bomba_id", referencedColumnName = "id")
    private BombaCombustivel bombaUsada;

    @Column(name = "litragem_combustivel")
    @NotNull
    private Double litragem;

    @Column(name = "valor_total")
    private Double valorTotal;

    @CreatedDate
    @Column(name = "data_abastecimento")
    private LocalDateTime dataAbastecimento;

    public Abastecimento(){

    }

    public Abastecimento(BombaCombustivel bombaUsada, Double litragem){
        this.bombaUsada = bombaUsada;
        this.litragem = litragem;

        this.valorTotal = litragem * bombaUsada.getCombustivel().getPrecoLitro();
    }

    public Long getId() {
        return id;
    }

    public BombaCombustivel getBombaUsada() {
        return bombaUsada;
    }

    public void setBombaUsada(BombaCombustivel bombaUsada) {
        this.bombaUsada = bombaUsada;
    }

    public Double getLitragem() {
        return litragem;
    }

    public void setLitragem(Double litragem) {
        this.litragem = litragem;
    }

    public LocalDateTime getDataAbastecimento() {
        return dataAbastecimento;
    }

    
}
