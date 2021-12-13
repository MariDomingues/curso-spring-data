package br.com.curso.spring.data.model.vo;

import br.com.curso.spring.data.model.entity.FuncionarioEntity;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import java.time.LocalDate;

public class FuncionarioVO {

    private int id;

    @NotEmpty
    private String nome;

    @NotEmpty
    private String cpf;

    @Positive
    private double salario;
    private LocalDate dataContratacao;

    public FuncionarioVO() {
    }

    public FuncionarioVO(FuncionarioEntity pFuncionario) {
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
