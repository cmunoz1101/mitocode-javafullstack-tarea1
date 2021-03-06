package com.mitocode.controller;

import com.mitocode.exception.ModeloNotFoundException;
import java.util.List;

import javax.validation.Valid;

import com.mitocode.model.Venta;
import com.mitocode.service.IVentaService;
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
@RequestMapping("/ventas")
public class VentaController {

    @Autowired
    private IVentaService ventaService;

    @GetMapping
    public ResponseEntity<List<Venta>> listar() {
        List<Venta> listaVentas = ventaService.listar();
        return new ResponseEntity<>(listaVentas, HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<Venta> registrar(@Valid @RequestBody Venta venta) throws Exception{
        Venta obj = ventaService.registrarTransaccional(venta);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdVenta()).toUri(); 
        return ResponseEntity.created(location).build();
    }

//    @PutMapping
//    public ResponseEntity<Venta> modificar(@Valid @RequestBody Venta venta) {
//        Venta obj = ventaService.modificar(venta);
//        return new ResponseEntity<>(obj, HttpStatus.OK);
//    }

//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) {
//        Venta obj = ventaService.listarPorId(id);
//        if (obj == null) {
//            throw new ModeloNotFoundException("Id no encontrado");
//        }
//        ventaService.eliminar(id);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }

//    @GetMapping("/{id}")
//    public ResponseEntity<Venta> listarPorId(@PathVariable("id") Integer id) {
//        Venta obj = ventaService.listarPorId(id);
//        if (obj == null) {
//            throw new ModeloNotFoundException("Id no encontrado");
//        }
//        return new ResponseEntity<>(obj, HttpStatus.OK);
//    }

}