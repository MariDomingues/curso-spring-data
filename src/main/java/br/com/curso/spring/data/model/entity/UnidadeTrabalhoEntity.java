package br.com.curso.spring.data.model.entity;

import br.com.curso.spring.data.model.vo.UnidadeTrabalhoVO;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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

    @ManyToMany(mappedBy = "unidadeTrabalho", fetch = FetchType.EAGER)
    private List<FuncionarioEntity> vFuncionario = new ArrayList<>();

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

    public List<FuncionarioEntity> getvFuncionario() {
        return vFuncionario;
    }

    public void setvFuncionario(List<FuncionarioEntity> vFuncionario) {
        this.vFuncionario = vFuncionario;
    }
}
