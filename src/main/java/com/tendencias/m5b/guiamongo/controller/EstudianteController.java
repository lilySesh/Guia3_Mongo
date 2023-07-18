/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tendencias.m5b.guiamongo.controller;

import com.tendencias.m5b.guiamongo.model.Estudiante;
import com.tendencias.m5b.guiamongo.service.EstudianteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author lilis
 */

@RestController
@RequestMapping("/api/estudiante")
public class EstudianteController {
     @Autowired
    EstudianteService personaService;

    @GetMapping("/listar")
    public ResponseEntity<List<Estudiante>> listarProductos() {
        return new ResponseEntity<>(personaService.findByAll(), 
                HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<Estudiante> crearProducto(
            @RequestBody Estudiante p) {
        return new ResponseEntity<>(personaService.save(p), 
                HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Estudiante> actualizarProducto(@PathVariable Long id, @RequestBody Estudiante p) {
        Estudiante estudianteENcontrada = personaService.findById(id);
        if (estudianteENcontrada == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                estudianteENcontrada.setNombre(p.getNombre());
                estudianteENcontrada.setCorreo(p.getCorreo());
                estudianteENcontrada.setGpa(p.getGpa());
                estudianteENcontrada.setCursoLista(p.getCursoLista());
                return new ResponseEntity<>(personaService.save(p), HttpStatus.OK);
            } catch (DataAccessException e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Estudiante> eliminarProducto(@PathVariable Long id) {
        personaService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
