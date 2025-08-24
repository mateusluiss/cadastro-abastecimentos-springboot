package com.desafiojr.desafio_01.models;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.NonNull;
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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@RequiredArgsConstructor
@NoArgsConstructor
@Table(name = "abastecimento")
@EntityListeners(AuditingEntityListener.class)
public class Abastecimento {
    //FK -> Bomba (BombasCombustível), Quantidade em valores e litragem(Abastecimento)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne
    @NonNull
    @JoinColumn(name = "bomba_id", referencedColumnName = "id")
    private BombaCombustivel bombaUsada;

    @NonNull
    @Column(name = "litragem_combustivel")
    @NotNull
    private Double litragem;

    @Column(name = "valor_total")
    private Double valorTotal;

    @CreatedDate
    @Column(name = "data_abastecimento")
    private LocalDateTime dataAbastecimento;
}
