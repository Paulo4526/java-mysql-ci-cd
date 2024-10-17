package com.github.fiap.java_mysql_ci_cd.controller;

import com.github.fiap.java_mysql_ci_cd.dto.ClimaCadastroDTO;
import com.github.fiap.java_mysql_ci_cd.dto.ClimaExibicaoDTO;
import com.github.fiap.java_mysql_ci_cd.model.Clima;
import com.github.fiap.java_mysql_ci_cd.service.ClimaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("clima")
public class ClimaController {


    @Autowired
    private ClimaService climaService;

    @PostMapping("/cadastrar")
    @ResponseStatus(HttpStatus.CREATED)
    public ClimaExibicaoDTO cadastrar (@RequestBody @Valid ClimaCadastroDTO climaCadastroDTO){
        return climaService.cadastrar(climaCadastroDTO);
    }


    @PutMapping("/atualizar")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ClimaExibicaoDTO atualizar(@RequestBody Clima clima){
        return climaService.atualizar(clima);
    }

    @DeleteMapping("excluir/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir (@PathVariable Long id){
        climaService.excluir(id);
    }

    @GetMapping("/listarTodos")
    @ResponseStatus(HttpStatus.OK)
    public Page<ClimaExibicaoDTO> listartodos (Pageable pageable){
        return climaService.listarTodos(pageable);
    }

}
