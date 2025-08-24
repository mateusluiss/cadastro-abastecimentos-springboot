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

import com.desafiojr.desafio_01.DTOs.BombaDTO;
import com.desafiojr.desafio_01.models.BombaCombustivel;
import com.desafiojr.desafio_01.services.BombaService;

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
    public BombaCombustivel listarBombaPorId(@PathVariable Long id){ //Optional enquanto não trata exceções
        return bombaService.listarBombaPorId(id);
    }

    @PostMapping
    public BombaDTO adicionarBomba(@RequestBody BombaDTO bomba){
        return bombaService.adicionarBomba(bomba);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BombaCombustivel> deletarBomba(@PathVariable Long id){
        bombaService.deletarBomba(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public BombaDTO atualizarBomba(@PathVariable Long id, @RequestBody BombaDTO bombaNova){
        return bombaService.atualizarBomba(id, bombaNova);
    }
}
