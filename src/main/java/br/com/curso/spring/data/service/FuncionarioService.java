package br.com.curso.spring.data.service;

import br.com.curso.spring.data.model.entity.CargoEntity;
import br.com.curso.spring.data.model.entity.FuncionarioEntity;
import br.com.curso.spring.data.model.entity.UnidadeTrabalhoEntity;
import br.com.curso.spring.data.model.vo.FuncionarioVO;
import br.com.curso.spring.data.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private CargoService cargoService;

    @Autowired
    private UnidadeTrabalhoService unidadeTrabalhoService;

    public void insert(FuncionarioVO pFuncionario) {

        FuncionarioEntity funcionario = new FuncionarioEntity(pFuncionario);
        funcionario.setCargo(new CargoEntity(cargoService.consult(pFuncionario.getIdCargo())));

        pFuncionario.getvIdUnidadeTrabalho().forEach(u -> {

            funcionario.getvUnidadeTrabalho().add(new UnidadeTrabalhoEntity(unidadeTrabalhoService.consult(u)));
        });

        funcionarioRepository.save(funcionario);
    }

    public void update(FuncionarioVO pFuncionario) {

        FuncionarioEntity funcionario = new FuncionarioEntity(pFuncionario);
        funcionario.setCargo(new CargoEntity(cargoService.consult(pFuncionario.getIdCargo())));

        pFuncionario.getvIdUnidadeTrabalho().forEach(u -> {

            funcionario.getvUnidadeTrabalho().add(new UnidadeTrabalhoEntity(unidadeTrabalhoService.consult(u)));
        });

        funcionarioRepository.save(funcionario);
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

    public List<FuncionarioVO> consult(String pNomeFuncionario) {

        List<FuncionarioVO> vFuncionario = new ArrayList<>();

        funcionarioRepository.findByNome(pNomeFuncionario).forEach(f -> vFuncionario.add(new FuncionarioVO(f)));

        return vFuncionario;
    }

    public List<FuncionarioVO> consult(LocalDate pDataContratacao) {

        List<FuncionarioVO> vFuncionario = new ArrayList<>();

        funcionarioRepository.findDataContratacaoMaior(pDataContratacao).forEach(f -> vFuncionario.add(new FuncionarioVO(f)));

        return vFuncionario;
    }

    public List<FuncionarioVO> consultPage(int pNumeroPagina) {

        Pageable page = PageRequest.of(pNumeroPagina, 2, Sort.by(Sort.Direction.DESC, "nome"));

        List<FuncionarioVO> vFuncionario = new ArrayList<>();

        funcionarioRepository.findAll(page).forEach(f -> vFuncionario.add(new FuncionarioVO(f)));

        return vFuncionario;
    }

    public List<FuncionarioVO> consultSalario() {

        List<FuncionarioVO> vFuncionario = new ArrayList<>();

        funcionarioRepository.findFuncionarioSalario().forEach(f -> vFuncionario.add(new FuncionarioVO(f)));

        return vFuncionario;
    }
}
