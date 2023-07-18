/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tendencias.m5b.guiamongo.service;

import com.tendencias.m5b.guiamongo.Repository.EstudianteRepository;
import com.tendencias.m5b.guiamongo.model.Estudiante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author lilis
 */
@Service  
public class EstudianteServiceImpl extends GenericServiceImpl<Estudiante, Long> implements EstudianteService{

    @Autowired
    EstudianteRepository estudianteRepository;
    
    @Override
    public CrudRepository<Estudiante, Long> getDao() {
        return estudianteRepository;
    }
    
}
