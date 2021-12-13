package br.com.curso.spring.data.model.entity;

import br.com.curso.spring.data.model.vo.FuncionarioVO;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import java.time.LocalDate;

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

    @OneToOne
    private CargoEntity cargo;

    @OneToOne
    private UnidadeTrabalhoEntity unidadeTrabalho;

    public FuncionarioEntity() {
    }

    public FuncionarioEntity(FuncionarioVO pFuncionario) {
        this.id = pFuncionario.getId();
        this.nome = pFuncionario.getNome();
        this.cpf = pFuncionario.getCpf();
        this.salario = pFuncionario.getSalario();
        this.dataContratacao = pFuncionario.getDataContratacao();
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public LocalDate getDataContratacao() {
        return dataContratacao;
    }

    public void setDataContratacao(LocalDate dataContratacao) {
        this.dataContratacao = dataContratacao;
    }
}
