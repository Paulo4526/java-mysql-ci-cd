package com.github.fiap.java_mysql_ci_cd.repository;

import com.github.fiap.java_mysql_ci_cd.model.Danos;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DanoRepository extends JpaRepository<Danos, Long> {

    //public Optional<Danos> findById_tornado (Long id);
    public Optional<Danos> findById (Long id);
}
