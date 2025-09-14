package projeto.sistema.de.biblioteca;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import dao.AutorRepository;
import dao.LivroRepository;
import model.Autor;

@ExtendWith(SpringExtension.class) // Integra os testes JUnit 5 com o Spring
@ContextConfiguration(locations = { "classpath:META-INF/spring-config.xml" }) // Indica ao Spring qual arquivo XML de
																				// configuração carregar
public class TesteProjeto {

	@Autowired
	private AutorRepository autorRepository;
	
	@Autowired
	private LivroRepository livroRepository;
	
		
	@Test
	public void testeSalvarAutor() {
		
		Autor autor = new Autor();
		
		autor.setNome("Thiago de Souza");
		autor.setNacionalidade("Brasileiro");
		
		autorRepository.save(autor);
		
		System.out.println(autor + " salvo com sucesso");
		
	}
	
	@Test
	public void testListarAutores() {
		
		Iterable<Autor> autor = autorRepository.findAll();
		
		for(Autor a : autor) {
			
		System.out.println("Id -> " + a.getId());
		System.out.println("Nome -> " + a.getNome());
		System.out.println("Nacionalidade -> " + a.getNacionalidade());
		System.out.println("------------------------------------");

		}

	}
}
