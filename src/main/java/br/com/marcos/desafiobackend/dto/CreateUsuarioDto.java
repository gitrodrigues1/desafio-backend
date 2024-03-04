package br.com.marcos.desafiobackend.dto;

import br.com.marcos.desafiobackend.model.UsuarioEnum;

public record CreateUsuarioDto(String nome, String cpf,  String email, String senha, UsuarioEnum uEnum ) {
    
}
