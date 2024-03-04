package br.com.marcos.desafiobackend.dto;

public record UpdateUsuarioDto(Long id, String nome, String cpf, String email, String senha) {
    
}
