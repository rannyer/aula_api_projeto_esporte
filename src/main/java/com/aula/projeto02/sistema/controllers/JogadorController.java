package com.aula.projeto02.sistema.controllers;

import com.aula.projeto02.sistema.models.Jogador;
import com.aula.projeto02.sistema.repositories.JogadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/jogador")
public class JogadorController {

    @Autowired
    private JogadorRepository jogadorRepository;


    @GetMapping
    public List<Jogador> getAll(){
        return jogadorRepository.findAll();
    }

    /**
     * Seleciona os jogadores pelo time_id
     * {time_id} -> variável de caminho
     * @param time_id chave estrangeira do time
     *
     * @Endpoint: http://localhost:8080/jogadores/time/1
     */
    @GetMapping("/time/{time_id}")
    public List<Jogador> getAllByTime(@PathVariable Long time_id){
        return jogadorRepository.findByTimeId(time_id);
    }

}

