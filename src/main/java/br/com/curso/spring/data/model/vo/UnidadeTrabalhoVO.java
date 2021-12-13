package br.com.curso.spring.data.model.vo;

import br.com.curso.spring.data.model.entity.UnidadeTrabalhoEntity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class UnidadeTrabalhoVO {

    private int id;

    @NotBlank
    @NotEmpty
    private String descricao;

    @NotBlank
    @NotEmpty
    private String endereco;

    public UnidadeTrabalhoVO() {
    }

    public UnidadeTrabalhoVO(UnidadeTrabalhoEntity pUnidadeTrabalho) {
        this.id = pUnidadeTrabalho.getId();
        this.descricao = pUnidadeTrabalho.getDescricao();
        this.endereco = pUnidadeTrabalho.getEndereco();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
