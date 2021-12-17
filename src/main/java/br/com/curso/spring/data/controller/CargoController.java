package br.com.curso.spring.data.controller;

import br.com.curso.spring.data.model.vo.CargoVO;
import br.com.curso.spring.data.service.CargoService;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cargo")
public class CargoController {

    @Autowired
    private CargoService cargoService;

    @PostMapping(value = "{cargo}")
    public ResponseEntity insert(@PathVariable("cargo") @NotNull @NotEmpty String pDescricaoCargo) {

        try {
            cargoService.insert(pDescricaoCargo);

        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao salvar o cargo: " + pDescricaoCargo);
        }

        return ResponseEntity.ok(pDescricaoCargo);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity update(@RequestBody @Valid CargoVO pCargo, BindingResult pResult) {

        try {
            if (pResult.hasErrors()) {
                throw new Exception();
            }

            cargoService.update(pCargo);

        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao atualizar o cargo: " + pCargo.getDescricao());
        }

        return ResponseEntity.ok(pCargo);
    }

    @GetMapping
    public ResponseEntity consult() {

        List<CargoVO> vCargo = new ArrayList<>();

        try {
            vCargo = cargoService.consult();

        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao carregar o(s) cargo(s) salvo(s)!");
        }

        return ResponseEntity.ok(vCargo);
    }

    @GetMapping(value = "{idCargo}")
    public ResponseEntity consult(@PathVariable("idCargo") @NotNull @NotEmpty int pIdCargo) {

        CargoVO cargo = new CargoVO();

        try {
            cargo = cargoService.consult(pIdCargo);

        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao carregar o cargo indicado!");
        }

        return ResponseEntity.ok(cargo);
    }

    @DeleteMapping(value = "{idCargo}")
    public ResponseEntity delete(@PathVariable("idCargo") @NotNull @NotEmpty int pIdCargo) {

        try {
            cargoService.delete(pIdCargo);

        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao excluir o cargo indicado!");
        }

        return ResponseEntity.ok(pIdCargo);
    }
}
