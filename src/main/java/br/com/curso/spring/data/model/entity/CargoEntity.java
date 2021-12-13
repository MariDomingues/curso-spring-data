package br.com.curso.spring.data.model.entity;

import br.com.curso.spring.data.model.vo.CargoVO;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Entity
@Table(name = "cargo")
public class CargoEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @NotEmpty
    private String descricao;

    @ManyToMany
    private FuncionarioEntity funcionario;

    public CargoEntity() {
    }

    public CargoEntity(CargoVO pCargo) {
        this.id = pCargo.getId();
        this.descricao = pCargo.getDescricao();
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
}
