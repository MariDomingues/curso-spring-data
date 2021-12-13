package br.com.curso.spring.data.service;

import br.com.curso.spring.data.model.entity.CargoEntity;
import br.com.curso.spring.data.model.vo.CargoVO;
import br.com.curso.spring.data.repository.CargoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CargoService {

    @Autowired
    private CargoRepository cargoRepository;

    public void insert(String pDescricaoCargo) {

        CargoEntity cargo = new CargoEntity();
        cargo.setDescricao(pDescricaoCargo);

        cargoRepository.save(cargo);
    }

    public List<CargoVO> consult() {

        Iterable<CargoEntity> cargoI = cargoRepository.findAll();

        List<CargoVO> vCargo = new ArrayList<>();

        cargoI.forEach(c -> vCargo.add(new CargoVO(c)));

        return vCargo;
    }

    public void update(CargoVO pCargo) {

        cargoRepository.save(new CargoEntity(pCargo));
    }

    public void delete(int pIdCargo) {

        cargoRepository.deleteById(pIdCargo);
    }

    public CargoVO consult(int pIdCargo) {

        Optional<CargoEntity> cargoConsult = cargoRepository.findById(pIdCargo);
        CargoVO cargo = new CargoVO();

        if (cargoConsult.isPresent()) {

            cargo.setId(cargoConsult.get().getId());
            cargo.setDescricao(cargoConsult.get().getDescricao());
        }

        return cargo;
    }
}
