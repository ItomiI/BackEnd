package com.tomi.proyecto.service.impl;

import com.tomi.proyecto.auth.model.User;
import com.tomi.proyecto.auth.repository.UserRepository;
import com.tomi.proyecto.exception.ResourceNotFoundException;
import com.tomi.proyecto.model.Dato;
import com.tomi.proyecto.model.Tipodato;
import com.tomi.proyecto.repository.DatoRepository;
import com.tomi.proyecto.repository.TipodatoRepository;
import com.tomi.proyecto.service.MiService;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class DatoServiceImpl implements MiService{
 
    private final DatoRepository datoRepository;
    private final TipodatoRepository tipodatoRepository;
    
    public DatoServiceImpl(DatoRepository datoRepository,TipodatoRepository tipodatoRepository){
        super();
        this.datoRepository = datoRepository;
        this.tipodatoRepository = tipodatoRepository;
        
    }
    
    @Override
    public Dato saveDato(Dato dato){
       return datoRepository.save(dato);
    } 
    
    @Override
    public Tipodato saveTipodato(Tipodato tipodato){
       return tipodatoRepository.save(tipodato);
    } 
    
    @Override
    public Tipodato getTipodatobyid(long id){ 
        return tipodatoRepository.findById(id).orElseThrow(()-> 
            new ResourceNotFoundException("tipodato","id",id));
    } 

    @Override
    public Dato getDatobyid(long id) {
       return datoRepository.findById(id).orElseThrow(()-> 
            new ResourceNotFoundException("tipodato","id",id));
    }

    @Override
    public void DeleteTipodatobyid(long id) {
         tipodatoRepository.deleteById(id);
    }

    @Override
    public void DeleteDatobyid(long id) {
        datoRepository.deleteById(id);
    }

    @Override
    public List<Dato> getAllDatos() {
        List<Dato> findAll = datoRepository.findAll();
        return findAll;
    }

    

    @Override
    public Dato editarDato(Dato dato) {
        datoRepository.editarDato(dato.getId(),dato.getLink(),dato.getNumero(),dato.getRutaimagen(),dato.getTexto(),dato.getTitulo());
   
        return datoRepository.findById(dato.getId()).orElseThrow(()-> 
            new ResourceNotFoundException("dato","id",dato.getId()));
        
    }

    @Override
    public List<Tipodato> getTipoDatos() {
        return tipodatoRepository.findAll();
                
    }
    
    
    
}
