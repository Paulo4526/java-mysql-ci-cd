package com.github.fiap.java_mysql_ci_cd.repository;
import com.github.fiap.java_mysql_ci_cd.model.Tornado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface TornadoRepository extends JpaRepository<Tornado, Long> {

    public Optional<Tornado> findById(Long id);
    public Optional<Tornado> findByNome(String nome);

    public List<Tornado> findByDataBetween (LocalDate dataInicial, LocalDate dataFinal);

}
