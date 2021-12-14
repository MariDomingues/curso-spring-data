package br.com.curso.spring.data.repository;

import br.com.curso.spring.data.model.entity.FuncionarioEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface FuncionarioRepository extends PagingAndSortingRepository<FuncionarioEntity, Integer> {

    List<FuncionarioEntity> findByNome(String pNome);

    //esta procurando funcionários pela descrição do cargo
    List<FuncionarioEntity> findByCargoDescricao(String pDescricao);

    @Query("SELECT f" +
            " FROM FuncionarioEntity f" +
            " JOIN f.cargo c" +
            " WHERE c.descricao = :pDescricao")
    List<FuncionarioEntity> findCargoDescricao(String pDescricao);

    //Derived Query Methods
    List<FuncionarioEntity> findByNomeAndSalarioGreaterThanAndDataContratacao(String pNome, double pSalario, LocalDate pDataContratacao);

    //JPQL, ou seja, query usando as nomenclaturas da classe
    @Query("SELECT f" +
            " FROM FuncionarioEntity AS f" +
            " WHERE f.nome = :pNome" +
            " AND f.salario = :pSalario" +
            " AND f.dataContratacao = :pDataContratacao")
    List<FuncionarioEntity> findNomeSalarioMaiorDataContratacao(String pNome, double pSalario, LocalDate pDataContratacao);

    List<FuncionarioEntity> findByvUnidadeTrabalho_Descricao(String pDescricao);

    @Query("SELECT f" +
            " FROM FuncionarioEntity f" +
            " JOIN f.vUnidadeTrabalho u" +
            " WHERE u.descricao = :pDescricao")
    List<FuncionarioEntity> findUnidadeTrabalhos_Descricao(String pDescricao);

    //native query, ou seja, query usando as nomenclaturas do banco
    @Query(value = "SELECT *" +
            " FROM funcionario AS f" +
            " WHERE f.data_contratacao >= :pDataContratacao",
            nativeQuery = true)
    List<FuncionarioEntity> findDataContratacaoMaior(LocalDate pDataContratacao);
}
