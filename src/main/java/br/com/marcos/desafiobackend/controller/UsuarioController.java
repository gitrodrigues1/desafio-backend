package br.com.marcos.desafiobackend.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.marcos.desafiobackend.dto.CreateUsuarioDto;
import br.com.marcos.desafiobackend.dto.GetUsuarioDto;
import br.com.marcos.desafiobackend.dto.UpdateUsuarioDto;
import br.com.marcos.desafiobackend.service.impl.UsuarioService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public GetUsuarioDto createUsuario(@RequestBody CreateUsuarioDto dto) {
        
        return usuarioService.create(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateUsuario(@RequestBody UpdateUsuarioDto dto, @PathVariable Long id ) {
        usuarioService.update(dto, id);
        return ResponseEntity.ok().body(null);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetUsuarioDto> getUsuario(@PathVariable Long id) {
        return ResponseEntity.ok().body(usuarioService.get(id));
    }
    
    
}
