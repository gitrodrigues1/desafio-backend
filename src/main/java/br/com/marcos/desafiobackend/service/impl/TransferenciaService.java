package br.com.marcos.desafiobackend.service.impl;

import org.springframework.stereotype.Service;

import br.com.marcos.desafiobackend.dto.GetTransferenciaDto;
import br.com.marcos.desafiobackend.model.Transferencia;
import br.com.marcos.desafiobackend.model.Usuario;
import br.com.marcos.desafiobackend.repository.CarteiraRepository;
import br.com.marcos.desafiobackend.repository.TransferenciaRepository;
import br.com.marcos.desafiobackend.repository.UsuarioRepository;
import br.com.marcos.desafiobackend.service.ITransferenciaService;

@Service
public class TransferenciaService implements ITransferenciaService {
    
    private final TransferenciaRepository transferenciaRepository;
    private final UsuarioRepository usuarioRepository;
    private final CarteiraRepository carteiraRepository;

    public TransferenciaService(TransferenciaRepository transferenciaRepository, 
            UsuarioRepository usuarioRepository,
            CarteiraRepository carteiraRepository) {
        this.transferenciaRepository = transferenciaRepository;
        this.usuarioRepository = usuarioRepository;
        this.carteiraRepository = carteiraRepository;
    }

    @Override
    public GetTransferenciaDto enviarDinheiro(Long origem, Long destino, Long valor) {
        Usuario uOrigem = usuarioRepository.findById(origem).get();
        Usuario uDestino = usuarioRepository.findById(destino).get();
        Long saldoOrigem = carteiraRepository.getSaldoByUsuarioId(uOrigem.getId());

        if (uOrigem.getTipoUsuario().equals("LOJISTA")) {
            throw new IllegalArgumentException("Operação inválida para Lojistas.");
        }

        if (saldoOrigem < valor) {
            throw new IllegalArgumentException("Saldo insuficiente");
        }

        carteiraRepository.updateSaldoByUsuarioId(uOrigem.getId(), saldoOrigem - valor );
        carteiraRepository.updateSaldoByUsuarioId(uDestino.getId(), saldoOrigem + valor);
        Transferencia t = transferenciaRepository.save(new Transferencia(null, origem, destino, valor));
        return t.toDto(t);

    }

    
}
