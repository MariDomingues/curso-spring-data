package br.com.curso.spring.data.repository;

import br.com.curso.spring.data.model.entity.UnidadeTrabalhoEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnidadeTrabalhoRepository extends CrudRepository<UnidadeTrabalhoEntity, Integer> {
}
