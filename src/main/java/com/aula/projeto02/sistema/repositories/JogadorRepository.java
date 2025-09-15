package com.aula.projeto02.sistema.repositories;

import com.aula.projeto02.sistema.models.Jogador;
import com.aula.projeto02.sistema.models.Time;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JogadorRepository extends JpaRepository<Jogador, Long> {
    List<Jogador> findByTimeId(Long id);
}
