package br.com.curso.spring.data.model.vo;

import br.com.curso.spring.data.model.entity.CargoEntity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class CargoVO {

    @NotNull(message = "Informe um id!")
    @Positive(message = "Informe um id!")
    private int id;

    @NotBlank(message = "Informe uma descrição!")
    @NotEmpty(message = "Informe uma descrição!")
    private String descricao;

    public CargoVO() {
    }

    public CargoVO(CargoEntity pCargo) {
        this.id = pCargo.getId();
        this.descricao = pCargo.getDescricao();
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
}
