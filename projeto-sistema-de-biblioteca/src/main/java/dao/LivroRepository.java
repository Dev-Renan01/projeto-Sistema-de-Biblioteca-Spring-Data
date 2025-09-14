package dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import model.Livro;

@Repository
public interface LivroRepository extends CrudRepository<Livro, Long>{

}
