package br.com.curso.spring.data.model.entity;

import br.com.curso.spring.data.model.vo.CargoVO;
import br.com.curso.spring.data.model.vo.UnidadeTrabalhoVO;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Entity
@Table(name = "unidadeTrabalho")
public class UnidadeTrabalhoEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @NotEmpty
    private String descricao;

    @NotEmpty
    private String endereco;

    @OneToMany
    private FuncionarioEntity funcionario;

    public UnidadeTrabalhoEntity() {
    }

    public UnidadeTrabalhoEntity(UnidadeTrabalhoVO pUnidadeTrabalho) {
        this.id = pUnidadeTrabalho.getId();
        this.descricao = pUnidadeTrabalho.getDescricao();
        this.endereco = pUnidadeTrabalho.getEndereco();
    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao.toUpperCase();
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public FuncionarioEntity getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(FuncionarioEntity funcionario) {
        this.funcionario = funcionario;
    }
}
