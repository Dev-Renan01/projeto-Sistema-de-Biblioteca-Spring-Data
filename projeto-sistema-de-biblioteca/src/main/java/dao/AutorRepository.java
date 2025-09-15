package dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import model.Autor;

@Repository
public interface AutorRepository extends CrudRepository<Autor, Long>{
	
	@Query(value = "select p from Autor p where p.nome like %?1%")
	public Autor findByNome(String nome);

}
