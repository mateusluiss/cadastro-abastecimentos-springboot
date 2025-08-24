package com.desafiojr.desafio_01.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafiojr.desafio_01.DTOs.AbastecimentoDTO;
import com.desafiojr.desafio_01.models.Abastecimento;
import com.desafiojr.desafio_01.services.AbastecimentoService;

@RestController
@RequestMapping("/api/abastecimentos")
public class AbastecimentoController {
    private final AbastecimentoService abastecimentoService;

    public AbastecimentoController(AbastecimentoService abastecimentoService){
        this.abastecimentoService = abastecimentoService;
    }

    @GetMapping
    public List<Abastecimento> listarAbastecimentos(){
        return abastecimentoService.listarAbastecimentos();
    }

    @GetMapping("/{id}")
    public Abastecimento listarAbastecimentoPorId(@PathVariable Long id){
        return abastecimentoService.listarAbastecimentoPorId(id);
    }

    @PostMapping
    public AbastecimentoDTO adicionarAbastecimento(@RequestBody AbastecimentoDTO abastecimentoDto){
        return abastecimentoService.adicionarAbastecimento(abastecimentoDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAbastecimento(Long id){
        abastecimentoService.deletarAbastecimento(id);
        return ResponseEntity.ok().build();
    }
}
