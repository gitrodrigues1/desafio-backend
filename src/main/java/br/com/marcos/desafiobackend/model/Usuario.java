package br.com.marcos.desafiobackend.model;

import br.com.marcos.desafiobackend.dto.CreateUsuarioDto;
import br.com.marcos.desafiobackend.dto.GetUsuarioDto;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "TB_USUARIO")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(nullable = false)
    private String nome;
    private String cpf;
    private String email;
    private String senha;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "carteira_id")
    private Carteira carteira;
    private UsuarioEnum tipoUsuario;

    public GetUsuarioDto toDto(Usuario usuario) {
        return new GetUsuarioDto(usuario.getId(), usuario.getNome(), usuario.getEmail());
    }

    public Usuario toModel(CreateUsuarioDto dto) {
        return Usuario.builder()
            .nome(dto.nome())
            .cpf(cpf)
            .email(dto.email())
            .senha(dto.senha())
            .tipoUsuario(dto.uEnum())
            .build();
    }


}
