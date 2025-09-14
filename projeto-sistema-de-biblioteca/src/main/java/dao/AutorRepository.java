package dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import model.Autor;

@Repository
public interface AutorRepository extends CrudRepository<Autor, Long>{

}
