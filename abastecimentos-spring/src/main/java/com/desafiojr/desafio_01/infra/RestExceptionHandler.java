package com.desafiojr.desafio_01.infra;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.desafiojr.desafio_01.exceptions.AbastecimentoNotFound;
import com.desafiojr.desafio_01.exceptions.BombaNotFoundException;
import com.desafiojr.desafio_01.exceptions.CombustivelNotFoundException;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler{
    
    @ExceptionHandler(BombaNotFoundException.class)
    private ResponseEntity<String> bombaNotFound(BombaNotFoundException exception){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }

    @ExceptionHandler(CombustivelNotFoundException.class)
    private ResponseEntity<String> combustivelNotFound(CombustivelNotFoundException exception){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }

    @ExceptionHandler(AbastecimentoNotFound.class)
    private ResponseEntity<String> abastecimentoNotFound(AbastecimentoNotFound exception){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }

}
