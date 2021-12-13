package br.com.curso.spring.data.model.vo;

import br.com.curso.spring.data.model.entity.CargoEntity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class CargoVO {

    @NotNull
    @Positive
    private int id;

    @NotBlank
    @NotEmpty
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

    public String getDescricao() {
        return descricao;
    }
}
