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

    @ManyToMany(mappedBy = "vUnidadeTrabalho", fetch = FetchType.EAGER)
    private List<FuncionarioEntity> vFuncionario = new ArrayList<>();

    public UnidadeTrabalhoEntity() {
    }

    public UnidadeTrabalhoEntity(UnidadeTrabalhoVO pUnidadeTrabalho) {
        this.id = pUnidadeTrabalho.getId();
        this.descricao = pUnidadeTrabalho.getDescricao().toUpperCase();
        this.endereco = pUnidadeTrabalho.getEndereco().toUpperCase();
    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getEndereco() {
        return endereco;
    }

    public List<FuncionarioEntity> getvFuncionario() {
        return vFuncionario;
    }
}
