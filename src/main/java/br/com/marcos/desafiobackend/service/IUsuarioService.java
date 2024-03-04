package br.com.marcos.desafiobackend.service;

import br.com.marcos.desafiobackend.dto.CreateUsuarioDto;
import br.com.marcos.desafiobackend.dto.GetUsuarioDto;
import br.com.marcos.desafiobackend.dto.UpdateUsuarioDto;

public interface IUsuarioService {
    
    GetUsuarioDto create(CreateUsuarioDto novoUsuario);
    GetUsuarioDto get(Long id);
    void update(UpdateUsuarioDto usuarioAtualizado, Long id);
    void delete(Long id);
    
}
