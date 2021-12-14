package br.com.curso.spring.data.controller;

import br.com.curso.spring.data.model.vo.FuncionarioVO;
import br.com.curso.spring.data.service.FuncionarioService;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity insert(@RequestBody @Valid FuncionarioVO pFuncionario) {

        try {
            funcionarioService.insert(pFuncionario);

        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao salvar o funcionário: " + pFuncionario.getNome());
        }

        return ResponseEntity.ok(pFuncionario);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity update(@RequestBody @Valid FuncionarioVO pFuncionario) {

        try {
            funcionarioService.update(pFuncionario);

        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao atualizar o funcionário: " + pFuncionario.getNome());
        }

        return ResponseEntity.ok(pFuncionario);
    }

    @GetMapping
    public ResponseEntity consult() {

        List<FuncionarioVO> vFuncionario = new ArrayList<>();

        try {
            vFuncionario = funcionarioService.consult();

        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao carregar o(s) funcionário(s) salvo(s)!");
        }

        return ResponseEntity.ok(vFuncionario);
    }

    @GetMapping(value = "{idFuncionario}")
    public ResponseEntity consult(@PathVariable("idFuncionario") @NotNull @NotEmpty int pIdFuncionario) {

        FuncionarioVO funcionario = new FuncionarioVO();

        try {
            funcionario = funcionarioService.consult(pIdFuncionario);

        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao carregar o funcionário indicado!");
        }

        return ResponseEntity.ok(funcionario);
    }

    @GetMapping(params = "pNomeFuncionario")
    public ResponseEntity consult(@NotNull @NotEmpty String pNomeFuncionario) {

        List<FuncionarioVO> vFuncionario = new ArrayList<>();

        try {
            vFuncionario = funcionarioService.consult(pNomeFuncionario.toUpperCase());

        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao carregar o funcionário indicado!");
        }

        return ResponseEntity.ok(vFuncionario);
    }

    @DeleteMapping(value = "{idFuncionario}")
    public ResponseEntity delete(@PathVariable("idFuncionario") @NotNull @NotEmpty int pIdFuncionario) {

        try {
            funcionarioService.delete(pIdFuncionario);

        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao excluir o funcionário indicado!");
        }

        return ResponseEntity.ok(pIdFuncionario);
    }
}
