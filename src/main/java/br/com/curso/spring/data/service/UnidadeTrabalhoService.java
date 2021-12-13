package br.com.curso.spring.data.service;

import br.com.curso.spring.data.model.entity.UnidadeTrabalhoEntity;
import br.com.curso.spring.data.model.vo.UnidadeTrabalhoVO;
import br.com.curso.spring.data.repository.UnidadeTrabalhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UnidadeTrabalhoService {

    @Autowired
    private UnidadeTrabalhoRepository unidadeTrabalhoRepository;

    public void insert(UnidadeTrabalhoVO pUnidadeTrabalho) {

        unidadeTrabalhoRepository.save(new UnidadeTrabalhoEntity(pUnidadeTrabalho));
    }

    public List<UnidadeTrabalhoVO> consult() {

        Iterable<UnidadeTrabalhoEntity> unidadeTrabalhoI = unidadeTrabalhoRepository.findAll();

        List<UnidadeTrabalhoVO> vUnidadeTrabalho = new ArrayList<>();

        unidadeTrabalhoI.forEach(c -> vUnidadeTrabalho.add(new UnidadeTrabalhoVO(c)));

        return vUnidadeTrabalho;
    }

    public void update(UnidadeTrabalhoVO pUnidadeTrabalho) {

        unidadeTrabalhoRepository.save(new UnidadeTrabalhoEntity(pUnidadeTrabalho));
    }

    public void delete(int pIdUnidadeTrabalho) {

        unidadeTrabalhoRepository.deleteById(pIdUnidadeTrabalho);
    }

    public UnidadeTrabalhoVO consult(int pIdUnidadeTrabalho) {

        Optional<UnidadeTrabalhoEntity> unidadeTrabalhoConsult = unidadeTrabalhoRepository.findById(pIdUnidadeTrabalho);
        UnidadeTrabalhoVO unidadeTrabalho = new UnidadeTrabalhoVO();

        if (unidadeTrabalhoConsult.isPresent()) {
            
            unidadeTrabalho = new UnidadeTrabalhoVO(unidadeTrabalhoConsult.get());
        }

        return unidadeTrabalho;
    }
}
