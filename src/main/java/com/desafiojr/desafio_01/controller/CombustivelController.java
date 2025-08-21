package com.desafiojr.desafio_01.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafiojr.desafio_01.models.Combustivel;
import com.desafiojr.desafio_01.service.CombustivelService;

@RestController
@RequestMapping("/api/combustiveis")
public class CombustivelController {
    private final CombustivelService combustivelService;

    public CombustivelController(CombustivelService combustivelService){
        this.combustivelService = combustivelService;
    }

    @GetMapping
    public List<Combustivel> listarCombustiveis(){
        return combustivelService.listarCombustiveis();
    }

    @GetMapping("/{id}")
    public Optional<Combustivel> listarCombustivelPorId(@PathVariable Long id){ //Optional enquanto não trata exceções
        return combustivelService.listarCombustivelPorId(id);
    }
}
