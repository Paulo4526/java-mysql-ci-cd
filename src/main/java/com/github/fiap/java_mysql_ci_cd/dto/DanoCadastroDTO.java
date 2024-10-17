package com.github.fiap.java_mysql_ci_cd.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DanoCadastroDTO(
        Long id,
        @NotNull(message = "Um id de tornado valido é obrigatório!")
        Long idTornado,
        @NotBlank(message = "O preenchimento do campo dano é obrigatório!")
        String dano,

        @NotBlank(message = "O preenchimento do campo dano é obrigatório!")
        String local
) {
}
