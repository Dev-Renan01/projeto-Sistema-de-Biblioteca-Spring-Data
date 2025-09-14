package projeto.sistema.de.biblioteca;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class) // Integra os testes JUnit 5 com o Spring
@ContextConfiguration(locations = { "classpath:META-INF/spring-config.xml" }) // Indica ao Spring qual arquivo XML de
																				// configuração carregar
public class TesteProjeto {

	@Test
	public void init() {
		System.out.println("Iniciado com sucesso!");
	}
}
