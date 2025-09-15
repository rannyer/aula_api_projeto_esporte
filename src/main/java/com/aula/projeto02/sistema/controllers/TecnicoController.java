package com.aula.projeto02.sistema.controllers;

import com.aula.projeto02.sistema.Dtos.TecnicoDto;
import com.aula.projeto02.sistema.models.Tecnico;
import com.aula.projeto02.sistema.repositories.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/tecnicos")
@RestController
public class TecnicoController {
    @Autowired
    TecnicoRepository tecnicoRepository;

    @GetMapping
    public List<Tecnico> getAll(){
        return  tecnicoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Tecnico getById(@PathVariable Long id){
        Optional<Tecnico> tecnico = tecnicoRepository.findById(id);
        if(tecnico.isEmpty()){
            return  null;
        }else{
            return tecnico.get();
        }
    }

    @PostMapping
    public Tecnico add(@RequestBody TecnicoDto tecnicoDto){
        Tecnico tecnico = new Tecnico();
        tecnico.setName(tecnicoDto.nome());
        tecnico.setNacionalidade(tecnicoDto.nacionalidade());
        return tecnicoRepository.save(tecnico);
    }
}
