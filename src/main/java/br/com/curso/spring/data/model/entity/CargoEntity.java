package br.com.curso.spring.data.model.entity;

import br.com.curso.spring.data.model.vo.CargoVO;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Locale;

@Entity
@Table(name = "cargo")
public class CargoEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String descricao;

    public CargoEntity() {
    }

    public CargoEntity(CargoVO pCargo) {
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
        this.descricao = descricao.toUpperCase();
    }
}
