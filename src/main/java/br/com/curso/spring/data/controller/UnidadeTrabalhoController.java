package br.com.curso.spring.data.controller;

import br.com.curso.spring.data.model.vo.UnidadeTrabalhoVO;
import br.com.curso.spring.data.service.UnidadeTrabalhoService;
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
@RequestMapping("/unidade-trabalho")
public class UnidadeTrabalhoController {

    @Autowired
    private UnidadeTrabalhoService unidadeTrabalhoService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity insert(@RequestBody @Valid UnidadeTrabalhoVO pUnidadeTrabalho, BindingResult pResult) {

        try {
            if (pResult.hasErrors()) {
                throw new Exception();
            }

            unidadeTrabalhoService.insert(pUnidadeTrabalho);

        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao salvar a unidade de trabalho: " + pUnidadeTrabalho.getDescricao());
        }

        return ResponseEntity.ok(pUnidadeTrabalho);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity update(@RequestBody @Valid UnidadeTrabalhoVO pUnidadeTrabalho, BindingResult pResult) {

        try {
            if (pResult.hasErrors()) {
                throw new Exception();
            }

            unidadeTrabalhoService.update(pUnidadeTrabalho);

        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao atualizar a unidade de trabalho: " + pUnidadeTrabalho.getDescricao());
        }

        return ResponseEntity.ok(pUnidadeTrabalho);
    }

    @GetMapping
    public ResponseEntity consult() {

        List<UnidadeTrabalhoVO> vUnidadeTrabalho = new ArrayList<>();

        try {
            vUnidadeTrabalho = unidadeTrabalhoService.consult();

        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao carregar a(s) unidade(s) de trabalho salva(s)!");
        }

        return ResponseEntity.ok(vUnidadeTrabalho);
    }

    @GetMapping(value = "{idUnidadeTrabalho}")
    public ResponseEntity consult(@PathVariable("idUnidadeTrabalho") @NotNull @NotEmpty int pIdUnidadeTrabalho) {

        UnidadeTrabalhoVO UnidadeTrabalho = new UnidadeTrabalhoVO();

        try {
            UnidadeTrabalho = unidadeTrabalhoService.consult(pIdUnidadeTrabalho);

        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao carregar a unidade de trabalho indicada!");
        }

        return ResponseEntity.ok(UnidadeTrabalho);
    }

    @DeleteMapping(value = "{idUnidadeTrabalho}")
    public ResponseEntity delete(@PathVariable("idUnidadeTrabalho") @NotNull @NotEmpty int pIdUnidadeTrabalho) {

        try {
            unidadeTrabalhoService.delete(pIdUnidadeTrabalho);

        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao excluir a unidade de trabalho indicada!");
        }

        return ResponseEntity.ok(pIdUnidadeTrabalho);
    }
}
