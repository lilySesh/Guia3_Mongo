/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tendencias.m5b.guiamongo.Repository;

import com.tendencias.m5b.guiamongo.model.Estudiante;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author lilis
 */
public interface EstudianteRepository extends MongoRepository<Estudiante, Long>{
    
}
