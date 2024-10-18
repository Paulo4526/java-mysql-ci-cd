package com.github.fiap.java_mysql_ci_cd.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "TB_MICRO_DANO")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Danos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_dano")
    private Long id;

    @Column(name = "id_tornado")
    private Long idTornado;

    @Column(name = "ds_dano")
    private String dano;

    @Column(name = "ds_local")
    private String local;
}