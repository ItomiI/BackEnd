package com.tomi.proyecto.service.impl;

import com.tomi.proyecto.model.Dato;
import com.tomi.proyecto.repository.DatoRepository;
import com.tomi.proyecto.service.DatoService;

import org.springframework.stereotype.Service;

@Service
public class DatoServiceImpl implements DatoService{

    
    private DatoRepository datoRepository;
    
   
    public DatoServiceImpl(DatoRepository datoRepository){
        super();
        this.datoRepository = datoRepository;
    }
    
    
    @Override
    public Dato saveDato(Dato dato) {
        
       return datoRepository.save(dato);
    }
    
}
