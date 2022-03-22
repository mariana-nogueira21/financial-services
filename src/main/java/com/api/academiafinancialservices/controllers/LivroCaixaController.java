package com.api.academiafinancialservices.controllers;

import com.api.academiafinancialservices.dtos.LivroCaixaDto;
import com.api.academiafinancialservices.models.LivroCaixaModel;
import com.api.academiafinancialservices.services.LivroCaixaService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/livrocaixa")
public class LivroCaixaController {

    @Autowired
    LivroCaixaService livroCaixaService;

    @PostMapping
    public ResponseEntity<Object> saveLivroCaixa(@RequestBody @Valid LivroCaixaDto livroCaixaDto) {
        var livroCaixaModel = new LivroCaixaModel();
        //conversão do Dto para Model
        BeanUtils.copyProperties(livroCaixaDto, livroCaixaModel);
        livroCaixaModel.setDataLancamento(LocalDate.now(ZoneId.of("UTC")));
        return ResponseEntity.status(HttpStatus.CREATED).body(livroCaixaService.save(livroCaixaModel));
    }

    @GetMapping
    public ResponseEntity<List<LivroCaixaModel>> getAllLivroCaixa() {
        return ResponseEntity.status(HttpStatus.OK).body(livroCaixaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneLivroCaixa(@PathVariable(value = "id")Integer id) {
        Optional<LivroCaixaModel> livroCaixaModelOptional = livroCaixaService.findById(id);
        if (!livroCaixaModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Livro caixa não encontrado.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(livroCaixaModelOptional.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteLivroCaixa(@PathVariable(value = "id")Integer id) {
        Optional<LivroCaixaModel> livroCaixaModelOptional = livroCaixaService.findById(id);
        if(!livroCaixaModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Livro caixa não encontrado.");
        }
        livroCaixaService.delete(livroCaixaModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Livro caixa deletado com sucesso.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateLivroCaixa(@PathVariable(value = "id")Integer id,
                                                   @RequestBody @Valid LivroCaixaDto livroCaixaDto) {
        Optional<LivroCaixaModel> livroCaixaModelOptional = livroCaixaService.findById(id);
        if (!livroCaixaModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Livro caixa não encontrado.");
        }
        var livroCaixaModel = new LivroCaixaModel();
        BeanUtils.copyProperties(livroCaixaDto, livroCaixaModel);
        livroCaixaModel.setId(livroCaixaModelOptional.get().getId());
        livroCaixaModel.setDataLancamento(livroCaixaModelOptional.get().getDataLancamento());
        return ResponseEntity.status(HttpStatus.OK).body(livroCaixaService.save(livroCaixaModel));
    }
}
