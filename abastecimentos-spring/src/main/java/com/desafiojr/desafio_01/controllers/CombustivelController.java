package com.desafiojr.desafio_01.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafiojr.desafio_01.DTOs.CombustivelDTO;
import com.desafiojr.desafio_01.models.Combustivel;
import com.desafiojr.desafio_01.services.CombustivelService;

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
    public Combustivel listarCombustivelPorId(@PathVariable Long id){ //Optional enquanto não trata exceções
        return combustivelService.listarCombustivelPorId(id);
    }

    @PostMapping
    public CombustivelDTO adicionarCombustivel(@RequestBody CombustivelDTO combustivel){
        return combustivelService.adicionarCombustivel(combustivel);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Combustivel> deletarCombustivel(@PathVariable Long id){
        combustivelService.deletarCombustivel(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public CombustivelDTO atualizarCombustivel(@PathVariable Long id, @RequestBody CombustivelDTO novoCombustivel){
        return combustivelService.atualizarCombustivel(id, novoCombustivel);
    }
    
}
