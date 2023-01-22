package com.tomi.proyecto.service.impl;

import com.tomi.proyecto.model.TipoDato;
import com.tomi.proyecto.repository.TipoDatoRepository;
import com.tomi.proyecto.service.TipoDatoService;

import org.springframework.stereotype.Service;

@Service
public class TipoDatoServiceImpl implements TipoDatoService {
    
    
    private TipoDatoRepository tipoDatoRepository;
    
    
    public TipoDatoServiceImpl(TipoDatoRepository tipoDatoRepository){
        super();
        this.tipoDatoRepository = tipoDatoRepository;
    }
    
    @Override
    public TipoDato saveTipoDato(TipoDato tipodato) {
       return tipoDatoRepository.save(tipodato);
    }
    
    
}
