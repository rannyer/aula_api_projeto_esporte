package com.aula.projeto02.sistema.controllers;

import com.aula.projeto02.sistema.Dtos.TimeDto;
import com.aula.projeto02.sistema.models.Tecnico;
import com.aula.projeto02.sistema.models.Time;
import com.aula.projeto02.sistema.repositories.TecnicoRepository;
import com.aula.projeto02.sistema.repositories.TimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/time")
public class TimeController {

    @Autowired
    private TimeRepository timeRepository;

    @Autowired
    private TecnicoRepository tecnicoRepository;


    @GetMapping
    public List<Time> getAll(){
        return timeRepository.findAll();
    }

    @GetMapping("/cidade/{cidade}")
    public List<Time> getByCidade(@PathVariable String cidade){
      return timeRepository.findByCidade(cidade);
    }

    @PostMapping
    public Time add(@RequestBody TimeDto timeDto){
        Optional<Tecnico> tecnico =tecnicoRepository.findById(timeDto.tecnico_id());
        if(tecnico.isEmpty()) return null;

        Time time =  new Time();
        time.setNome(timeDto.nome());
        time.setCidade(timeDto.cidade());
        time.setTecnico(tecnico.get());
        return timeRepository.save(time);

    }
 }
