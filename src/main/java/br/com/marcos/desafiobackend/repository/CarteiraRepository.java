package br.com.marcos.desafiobackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import br.com.marcos.desafiobackend.model.Carteira;

public interface CarteiraRepository extends JpaRepository<Carteira, Long>{
    
    Long getSaldoByUsuarioId(Long id);

    @Modifying
    @Query("Update Carteira c set c.saldo = ?2 where c.id =?1")
    void updateSaldoByUsuarioId(Long id, Long saldo);
}
