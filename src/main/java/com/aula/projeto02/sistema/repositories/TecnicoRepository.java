package com.aula.projeto02.sistema.repositories;

import com.aula.projeto02.sistema.models.Tecnico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TecnicoRepository extends JpaRepository<Tecnico, Long> {
}
