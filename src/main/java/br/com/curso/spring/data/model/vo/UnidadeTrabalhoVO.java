package br.com.curso.spring.data.model.vo;

import br.com.curso.spring.data.model.entity.CargoEntity;
import br.com.curso.spring.data.model.entity.UnidadeTrabalhoEntity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class UnidadeTrabalhoVO {

    @NotNull(message = "Informe um id!")
    @Positive(message = "Informe um id!")
    private int id;

    @NotBlank(message = "Informe uma descrição!")
    @NotEmpty(message = "Informe uma descrição!")
    private String descricao;

    @NotBlank(message = "Informe um endereço!")
    @NotEmpty(message = "Informe um endereço!")
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
