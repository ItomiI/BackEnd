package com.tomi.proyecto.controller;


import com.tomi.proyecto.model.Dato;
import com.tomi.proyecto.model.Tipodato;
import com.tomi.proyecto.service.MiService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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


@RestController
@RequestMapping("miapi")
public class DatoController {
    

    private MiService elSuperService; 

    public DatoController(MiService elSuperService) {
        super();
        this.elSuperService = elSuperService;
    }
    
    @PostMapping("datos/{idtipo}")//guardar algo nuevo
    public ResponseEntity<Dato> saveDato(@RequestBody Dato dato,@PathVariable("idtipo") long id){
        
        Dato midato = new Dato();
        midato.setLink(dato.getLink());
        midato.setNumero(dato.getNumero());
        midato.setRutaimagen(dato.getRutaimagen());
        midato.setTexto(dato.getTexto());
        midato.setTipodato(elSuperService.getTipodatobyid(id));
        midato.setTitulo(dato.getTitulo());
       
        return new ResponseEntity<>(elSuperService.saveDato(midato),HttpStatus.CREATED);
    }
    
    @PostMapping("tipodato")//
    public ResponseEntity<Tipodato> saveTipodato(@RequestBody Tipodato tipodato){
        return new ResponseEntity<>(elSuperService.saveTipodato(tipodato),HttpStatus.CREATED);
    }
    
    @GetMapping("datos/{id}")//obtener un dato por id
     public ResponseEntity<Dato> getDato(@PathVariable("id") long id){
        return new ResponseEntity<>(elSuperService.getDatobyid(id),HttpStatus.FOUND);
    }
    
    @GetMapping("alldatos")//devuelve todo
     public ResponseEntity<List<Dato>> getAllDatos(){
         
       return new ResponseEntity<>(elSuperService.getAllDatos(),HttpStatus.FOUND);
    }
    @DeleteMapping("datos/{id}")//borra por id
    public ResponseEntity<HttpStatus> deleteDato(@PathVariable("id") long id){
        elSuperService.DeleteDatobyid(id);
        return new ResponseEntity<>(HttpStatus.GONE);
    }
    
    //editarDato
    @PutMapping("editar")
        public ResponseEntity<Dato> editarDato(@RequestBody Dato dato){
                   
        return new ResponseEntity<>(elSuperService.editarDato(dato),HttpStatus.OK);
    }
        
    @GetMapping("hola")
    public ResponseEntity<String> aawrbwabr (){
        return new ResponseEntity<>("hola",HttpStatus.OK);
    }
    
     
    
        
        
        
        
        
   
}
