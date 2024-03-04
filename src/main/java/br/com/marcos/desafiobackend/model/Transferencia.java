package br.com.marcos.desafiobackend.model;

import br.com.marcos.desafiobackend.dto.CreateTransferenciaDto;
import br.com.marcos.desafiobackend.dto.GetTransferenciaDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Transferencia {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Long origem;
    private Long destinatario;
    private Long valorTransferencia;

    public Transferencia toModel(CreateTransferenciaDto dto) {
        return Transferencia.builder()
                .origem(dto.origem())
                .destinatario(dto.destino())
                .valorTransferencia(dto.valor())
                .build();
    }

    public GetTransferenciaDto toDto(Transferencia transferencia) {
        return new GetTransferenciaDto(
            transferencia.getId(), 
            transferencia.getValorTransferencia()
        );
    }

}
