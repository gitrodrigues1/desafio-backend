package br.com.marcos.desafiobackend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.marcos.desafiobackend.dto.CreateTransferenciaDto;
import br.com.marcos.desafiobackend.dto.GetTransferenciaDto;
import br.com.marcos.desafiobackend.service.impl.TransferenciaService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/transferencias")
public class TransferenciaController {
    
    private final TransferenciaService transferenciaService;

    public TransferenciaController(TransferenciaService transferenciaService) {
        this.transferenciaService = transferenciaService;
    }

    @PostMapping
    public ResponseEntity<GetTransferenciaDto> createTransferencia(@RequestBody CreateTransferenciaDto dto) {
        return ResponseEntity.ok().body(transferenciaService.enviarDinheiro(dto.origem(), dto.destino(), dto.valor())); 
    }
}
