package br.com.curso.spring.data.repository.specification;

import br.com.curso.spring.data.model.entity.FuncionarioEntity;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;

public class FuncionarioSpecification {

    public static Specification<FuncionarioEntity> nome(String nome) {
        return (root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.like(root.get("nome"), "%" + nome + "%");
    }

    public static Specification<FuncionarioEntity> cpf(String cpf) {
        return (root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("cpf"), cpf);
    }

    public static Specification<FuncionarioEntity> salario(Double salario) {
        return (root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.greaterThan(root.get("salario"), salario);
    }

    public static Specification<FuncionarioEntity> dataContratacao(LocalDate dataContratacao) {
        return (root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.greaterThan(root.get("dataContratacao"), dataContratacao);
    }
}