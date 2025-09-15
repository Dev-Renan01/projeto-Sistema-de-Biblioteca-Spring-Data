package dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import model.Livro;

@Repository
public interface LivroRepository extends CrudRepository<Livro, Long>{

	@Query("SELECT l FROM Livro l JOIN l.autor a WHERE a.nome LIKE %:nome%")
	List<Livro> findByAutorNome(@Param("nome") String nome);

}
