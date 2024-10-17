package com.github.fiap.java_mysql_ci_cd.dto;

import com.github.fiap.java_mysql_ci_cd.model.Tornado;

import java.time.LocalDate;

public record TornadoExibicaoDTO(
        Long id,
        String nome,
        String classificacao,
        String local,
        LocalDate data
) {
    public TornadoExibicaoDTO (Tornado tornado){
        this(tornado.getId(), tornado.getNome(), tornado.getClassificacao(), tornado.getLocal(), tornado.getData());
    }
}
