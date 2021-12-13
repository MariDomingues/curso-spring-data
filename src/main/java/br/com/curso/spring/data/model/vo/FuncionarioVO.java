package br.com.curso.spring.data.model.vo;

import br.com.curso.spring.data.classe.Data;
import br.com.curso.spring.data.model.entity.FuncionarioEntity;
import com.fasterxml.jackson.annotation.JsonAlias;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioVO {

    private int id;

    @NotEmpty
    private String nome;

    @NotEmpty
    private String cpf;

    @Positive
    private int idCargo;

    @NotEmpty
    private String dataContratacao;

    private double salario;

    @JsonAlias("unidadeTrabalho")
    private List<Integer> vIdUnidadeTrabalho = new ArrayList<>();

    public FuncionarioVO() {
    }

    public FuncionarioVO(FuncionarioEntity pFuncionario) {
        this.id = pFuncionario.getId();
        this.nome = pFuncionario.getNome();
        this.cpf = pFuncionario.getCpf();
        this.salario = pFuncionario.getSalario();
        this.dataContratacao = Data.getDataGUI(pFuncionario.getDataContratacao());
        this.idCargo = pFuncionario.getCargo().getId();
        pFuncionario.getvUnidadeTrabalho().forEach(u -> this.vIdUnidadeTrabalho.add(u.getId()));
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

    public String getDataContratacao() {
        return dataContratacao;
    }

    public int getIdCargo() {
        return idCargo;
    }

    public List<Integer> getvIdUnidadeTrabalho() {
        return vIdUnidadeTrabalho;
    }
}
