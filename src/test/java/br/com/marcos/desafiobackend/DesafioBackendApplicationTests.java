package br.com.marcos.desafiobackend;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.marcos.desafiobackend.model.Carteira;
import br.com.marcos.desafiobackend.model.Usuario;

@SpringBootTest
class DesafioBackendApplicationTests {

	@Test
	void contextLoads() {
	}

	@BeforeEach
	public void setup() {
		Usuario u = Usuario.builder()
				.nome("Marcos")
				.cpf("999999999-99")
				.email("m@gmail.com")
				.senha("123456")
				.build();

		Carteira c = Carteira.builder()
				.usuario(u)
				.saldo(1000.00)
				.build();
	}

}
