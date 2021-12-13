package br.com.curso.spring.data.model.entity;

import br.com.curso.spring.data.classe.Data;
import br.com.curso.spring.data.model.vo.FuncionarioVO;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "funcionario")
public class FuncionarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @NotEmpty
    private String nome;

    @NotEmpty
    @CPF
    private String cpf;

    @Positive
    private double salario;
    private LocalDate dataContratacao;

    @ManyToOne
    @JoinColumn(name = "id_cargo", nullable = false)
    private CargoEntity cargo;

    @Fetch(FetchMode.SELECT)
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "funcionario_unidade",
            joinColumns = {@JoinColumn(name = "id_funcionario")},
            inverseJoinColumns = {@JoinColumn(name = "id_unidade")})
    private List<UnidadeTrabalhoEntity> vUnidadeTrabalho = new ArrayList<>();

    public FuncionarioEntity() {
    }

    public FuncionarioEntity(FuncionarioVO pFuncionario) {
        this.id = pFuncionario.getId();
        this.nome = pFuncionario.getNome().toUpperCase();
        this.cpf = pFuncionario.getCpf();
        this.salario = pFuncionario.getSalario();
        this.dataContratacao = Data.getDataBanco(pFuncionario.getDataContratacao());
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public double getSalario() {
        return salario;
    }

    public LocalDate getDataContratacao() {
        return dataContratacao;
    }

    public CargoEntity getCargo() {
        return cargo;
    }

    public List<UnidadeTrabalhoEntity> getvUnidadeTrabalho() {
        return vUnidadeTrabalho;
    }

    public void setCargo(CargoEntity cargo) {
        this.cargo = cargo;
    }

    public void setvUnidadeTrabalho(List<UnidadeTrabalhoEntity> vUnidadeTrabalho) {
        this.vUnidadeTrabalho = vUnidadeTrabalho;
    }
}
