package br.com.marcos.desafiobackend.service;

import br.com.marcos.desafiobackend.dto.GetTransferenciaDto;

public interface ITransferenciaService {
    
    GetTransferenciaDto enviarDinheiro(Long origem, Long destino, Long valor);
}
