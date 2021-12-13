package br.com.curso.spring.data.repository;

import br.com.curso.spring.data.model.entity.CargoEntity;
import br.com.curso.spring.data.model.entity.FuncionarioEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepository extends CrudRepository<FuncionarioEntity, Integer> {
}
