package com.mitocode.controller;

import com.mitocode.exception.ModeloNotFoundException;
import java.util.List;

import javax.validation.Valid;

import com.mitocode.model.Persona;
import com.mitocode.service.IPersonaService;
import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 *
 * @author cmunoz
 */
@RestController
@RequestMapping("/personas")
public class PersonaController {

    @Autowired
    private IPersonaService personaService;

    @GetMapping
    public ResponseEntity<List<Persona>> listar() {
        List<Persona> listaPersonas = personaService.listar();
        return new ResponseEntity<>(listaPersonas, HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<Persona> registrar(@Valid @RequestBody Persona persona) {
        Persona obj = personaService.registrar(persona);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdPersona()).toUri(); 
        return ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<Persona> modificar(@Valid @RequestBody Persona persona) {
        Persona obj = personaService.modificar(persona);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) {
        Persona obj = personaService.listarPorId(id);
        if (obj == null) {
            throw new ModeloNotFoundException("Id no encontrado");
        }
        personaService.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Persona> listarPorId(@PathVariable("id") Integer id) {
        Persona obj = personaService.listarPorId(id);
        if (obj == null) {
            throw new ModeloNotFoundException("Id no encontrado");
        }
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

}