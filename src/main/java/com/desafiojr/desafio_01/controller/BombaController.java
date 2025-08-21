package com.desafiojr.desafio_01.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafiojr.desafio_01.models.BombaCombustivel;
import com.desafiojr.desafio_01.service.BombaService;

@RestController
@RequestMapping("/api/bombas")
public class BombaController {
    private final BombaService bombaService;

    public BombaController(BombaService bombaService){
        this.bombaService = bombaService;
    }

    @GetMapping
    public List<BombaCombustivel> listarBombas(){
        return bombaService.listarBombas();
    }

    @GetMapping("/{id}")
    public Optional<BombaCombustivel> listarBombaPorId(@PathVariable Long id){ //Optional enquanto não trata exceções
        return bombaService.listarBombaPorId(id);
    }
}
