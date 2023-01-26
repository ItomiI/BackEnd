package com.tomi.proyecto.controller;

import com.tomi.proyecto.model.Dato;
import com.tomi.proyecto.model.Tipodato;
import com.tomi.proyecto.service.MiService;
import java.util.List;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("miapi")
public class DatoController {
    
    private final MiService datoService; 

    public DatoController(MiService datoService) {
        super();
        this.datoService = datoService;
    }
    
    @PostMapping("datos/{idtipo}")
    public ResponseEntity<Dato> saveDato(@RequestBody Dato dato,@PathVariable("idtipo") long id){
        
        Dato midato = new Dato();
        midato.setLink(dato.getLink());
        midato.setNumero(dato.getNumero());
        midato.setRutaimagen(dato.getRutaimagen());
        midato.setTexto(dato.getTexto());
        midato.setTipodato(datoService.getTipodatobyid(id));
        midato.setTitulo(dato.getTitulo());
       
        return new ResponseEntity<>(datoService.saveDato(midato),HttpStatus.CREATED);
    }
    
    @PostMapping("tipodato")
    public ResponseEntity<Tipodato> saveTipodato(@RequestBody Tipodato tipodato){
        return new ResponseEntity<>(datoService.saveTipodato(tipodato),HttpStatus.CREATED);
    }
    
    @GetMapping("datos/{id}")
     public ResponseEntity<Dato> getDato(@PathVariable("id") long id){
        return new ResponseEntity<>(datoService.getDatobyid(id),HttpStatus.FOUND);
    }
    
    @GetMapping("alldatos")
     public ResponseEntity<List<Dato>> getAllDatos(){
        //HttpHeaders responseHeaders = new HttpHeaders();
       // responseHeaders.set("Access-Control-Allow-Origin:", " http://localhost:4200");
                
       return new ResponseEntity<>(datoService.getAllDatos()/*,responseHeaders*/,HttpStatus.FOUND);
    }
    @DeleteMapping("datos/{id}")
    public ResponseEntity<HttpStatus> deleteDato(@PathVariable("id") long id){
        datoService.DeleteDatobyid(id);
        return new ResponseEntity<>(HttpStatus.GONE);
    }
     
   
}
