package br.com.marcos.desafiobackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.marcos.desafiobackend.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    
}
