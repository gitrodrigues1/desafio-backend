package br.com.marcos.desafiobackend.service.impl;

import org.springframework.stereotype.Service;

import br.com.marcos.desafiobackend.dto.CreateUsuarioDto;
import br.com.marcos.desafiobackend.dto.GetUsuarioDto;
import br.com.marcos.desafiobackend.dto.UpdateUsuarioDto;
import br.com.marcos.desafiobackend.model.Usuario;
import br.com.marcos.desafiobackend.repository.UsuarioRepository;
import br.com.marcos.desafiobackend.service.IUsuarioService;

@Service
public class UsuarioService implements IUsuarioService{

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public GetUsuarioDto create(CreateUsuarioDto novoUsuario) {
        Usuario u = new Usuario().toModel(novoUsuario);
        return usuarioRepository.save(u).toDto(u);
    }

    @Override
    public GetUsuarioDto get(Long id) {
        //[ ] Implmentar exception para usuario não encontrado
        Usuario usuarioEncontrado = usuarioRepository.findById(id).get();
        return usuarioEncontrado.toDto(usuarioEncontrado);
    }

    @Override
    public void update(UpdateUsuarioDto updateUsuarioDto, Long id) {
        //[ ] Implmentar exception para usuario não encontrado ao atualizar
        if (usuarioRepository.existsById(updateUsuarioDto.id())) {
            Usuario u = Usuario.builder()
                .id(id)
                .nome(updateUsuarioDto.nome())
                .cpf(updateUsuarioDto.cpf())
                .email(updateUsuarioDto.email())
                .senha(updateUsuarioDto.senha())
                .build();

            usuarioRepository.save(u);
        }      
    }

    @Override
    public void delete(Long id) {
        usuarioRepository.deleteById(id);
    }
    
}
