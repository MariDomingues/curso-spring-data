package br.com.curso.spring.data.service;

import br.com.curso.spring.data.model.entity.CargoEntity;
import br.com.curso.spring.data.model.entity.FuncionarioEntity;
import br.com.curso.spring.data.model.vo.CargoVO;
import br.com.curso.spring.data.model.vo.FuncionarioVO;
import br.com.curso.spring.data.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public void insert(FuncionarioVO pFuncionario) {

        funcionarioRepository.save(new FuncionarioEntity(pFuncionario));
    }

    public void update(FuncionarioVO pFuncionario) {

        funcionarioRepository.save(new FuncionarioEntity(pFuncionario));
    }

    public List<FuncionarioVO> consult() {

        Iterable<FuncionarioEntity> funcionarioI = funcionarioRepository.findAll();

        List<FuncionarioVO> vFuncionario = new ArrayList<>();

        funcionarioI.forEach(c -> vFuncionario.add(new FuncionarioVO(c)));

        return vFuncionario;
    }

    public FuncionarioVO consult(int pIdFuncionario) {

        Optional<FuncionarioEntity> funcionarioConsult = funcionarioRepository.findById(pIdFuncionario);
        FuncionarioVO funcionario = new FuncionarioVO();

        if (funcionarioConsult.isPresent()) {

            funcionario = new FuncionarioVO(funcionarioConsult.get());
        }

        return funcionario;
    }

    public void delete(int pIdFuncionario) {

        funcionarioRepository.deleteById(pIdFuncionario);
    }
}
