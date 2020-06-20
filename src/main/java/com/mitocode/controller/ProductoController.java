package com.mitocode.controller;

import com.mitocode.exception.ModeloNotFoundException;
import java.util.List;

import javax.validation.Valid;

import com.mitocode.model.Producto;
import com.mitocode.service.IProductoService;
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
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private IProductoService productoService;

    @GetMapping
    public ResponseEntity<List<Producto>> listar() {
        List<Producto> listaProductos = productoService.listar();
        return new ResponseEntity<>(listaProductos, HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<Producto> registrar(@Valid @RequestBody Producto producto) {
        Producto obj = productoService.registrar(producto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdProducto()).toUri(); 
        return ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<Producto> modificar(@Valid @RequestBody Producto producto) {
        Producto obj = productoService.modificar(producto);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) {
        Producto obj = productoService.listarPorId(id);
        if (obj == null) {
            throw new ModeloNotFoundException("Id no encontrado");
        }
        productoService.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> listarPorId(@PathVariable("id") Integer id) {
        Producto obj = productoService.listarPorId(id);
        if (obj == null) {
            throw new ModeloNotFoundException("Id no encontrado");
        }
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

}