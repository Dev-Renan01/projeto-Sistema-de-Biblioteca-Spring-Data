package projeto.sistema.de.biblioteca;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import dao.AutorRepository;
import dao.LivroRepository;
import model.Autor;
import model.Livro;

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
		
		autor.setNome("Reginaldo de Alencar");
		autor.setNacionalidade("Brasileiro");
		
		autorRepository.save(autor);
		
		System.out.println(autor + " salvo com sucesso");
		
	}
	
	@Test
	public void testeListarAutores() {
		
		Iterable<Autor> autor = autorRepository.findAll();
		
		for(Autor a : autor) {
			
		System.out.println("Id -> " + a.getId());
		System.out.println("Nome -> " + a.getNome());
		System.out.println("Nacionalidade -> " + a.getNacionalidade());
		System.out.println("------------------------------------");

		}
	}
	
	@Test
	public void testeAutualizarAutor() {
		
		Optional<Autor> autor = autorRepository.findById(2L);
	
		System.out.println("Nome atual: " + autor.get().getNome());
		System.out.println("Nacionalidade atual: " + autor.get().getNacionalidade());

		autor.get().setNome("Suany Vieira");
		autor.get().setNacionalidade("Brasileira");
		
		System.out.println("------------------------------------");

		System.out.println("Nome atualizado: " + autor.get().getNome());
		System.out.println("Nacionalidade atualizado: " + autor.get().getNacionalidade());

	}
	
	@Test
	public void testeDeletarAutor() {
		
		autorRepository.deleteById(1L);
		
		System.out.println("Deletado com sucesso!");
	}
	
	
	//========================================
	
	
	@Test
	public void testeSalvarLivro() {
		
		Optional<Autor> autor = autorRepository.findById(2L);
		
		Livro livro = new Livro();
		
		
		livro.setTitulo("O Drama");
		livro.setAnoPublicado(2023);
		livro.setAutor(autor.get());
		
		livroRepository.save(livro);
		
		System.out.println(livro + " salvo com sucesso");
		
	}
	
	@Test
	public void testeListarLivros() {
		
		Iterable<Livro> livro = livroRepository.findAll();
		
		for(Livro l : livro) {
			
		System.out.println("Id -> " + l.getId());
		System.out.println("Nome -> " + l.getTitulo());
		System.out.println("Nacionalidade -> " + l.getAnoPublicado());
		System.out.println(l.getAutor());
		System.out.println("------------------------------------");

		}
	}
	
	@Test
	public void testeAutualizarlivro() {
		
		Optional<Livro> livro = livroRepository.findById(2L);
	
		System.out.println("Nome atual: " + livro.get().getTitulo());
		System.out.println("Nacionalidade atual: " + livro.get().getAnoPublicado());

		livro.get().setTitulo("Algoritimos computacionais");
		livro.get().setAnoPublicado(2020);
		
		System.out.println("------------------------------------");

		System.out.println("Nome atualizado: " + livro.get().getTitulo());
		System.out.println("Nacionalidade atualizado: " + livro.get().getAnoPublicado());

	}
	
	@Test
	public void testeDeletarlivro() {
		
		Optional<Livro> livro = livroRepository.findById(1L);
		
		livroRepository.delete(livro.get());
		
		System.out.println("Deletado com sucesso!");
	}
	
	
	
	
	
}
