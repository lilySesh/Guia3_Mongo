/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tendencias.m5b.guiamongo.model;

import com.tendencias.m5b.guiamongo.controller.*;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author lilis
 */
@Document(collection="Persona")
@Data
public class Estudiante {
    @Id
    private int id;
    private String nombre;
    private String correo;
    private String cursoLista;
    private String gpa;
    
    
    
}
