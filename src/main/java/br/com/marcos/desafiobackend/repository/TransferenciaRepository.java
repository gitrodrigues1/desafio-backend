package br.com.marcos.desafiobackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.marcos.desafiobackend.model.Transferencia;

public interface TransferenciaRepository extends JpaRepository<Transferencia, Long>{
    
}
