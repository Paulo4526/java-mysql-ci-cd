package com.github.fiap.java_mysql_ci_cd.dto;

import com.github.fiap.java_mysql_ci_cd.model.Danos;

public record DanoExibicaoDTO(
        Long id,
        Long idTornado,
        String dano,
        String local

) {
    public DanoExibicaoDTO (Danos danos){
        this(danos.getId(), danos.getIdTornado(), danos.getDano(), danos.getLocal());
    }
}
