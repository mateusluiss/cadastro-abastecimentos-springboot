package com.desafiojr.desafio_01.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "bomba")
public class BombaCombustivel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "nome_bomba")
    private String nomeBomba;

    @NotNull
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "cobustivel_id", referencedColumnName = "id") //Cria FK
    private Combustivel combustivel;

    public BombaCombustivel(){

    }

    public BombaCombustivel(String nomeBomba, Combustivel combustivel){
        this.nomeBomba = nomeBomba;
        this.combustivel = combustivel;
    }

    public Long getId() {
        return id;
    }

    public String getNomeBomba() {
        return nomeBomba;
    }

    public void setNomeBomba(String nomeBomba) {
        this.nomeBomba = nomeBomba;
    }

    public Combustivel getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(Combustivel combustivel) {
        this.combustivel = combustivel;
    }
}
