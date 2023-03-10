package com.tomi.proyecto.controller;


import com.tomi.proyecto.DTO.EditarRequest;
import com.tomi.proyecto.DTO.EliminarRequest;
import com.tomi.proyecto.auth.service.AuthService;
import com.tomi.proyecto.metodos.Metodos;
import com.tomi.proyecto.model.Dato;
import com.tomi.proyecto.model.Tipodato;
import com.tomi.proyecto.service.MiService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@CrossOrigin(origins = "http://localhost:4200/")
@CrossOrigin(origins = "https://portfolio-28276.web.app/")
@RestController
@RequestMapping("miapi")
public class DatoController {
    

    private final MiService elSuperService; 
    private final AuthService authservice;
    private final Metodos encripter;
    
    public DatoController(MiService elSuperService,AuthService authservice) {
        super();
        this.elSuperService = elSuperService;
        this.encripter = new Metodos();
        this.authservice= authservice;
    }
    
    
    @GetMapping("datos/{id}")//obtener un dato por id
     public ResponseEntity<Dato> getDato(@PathVariable("id") long id){
        return new ResponseEntity<>(elSuperService.getDatobyid(id),HttpStatus.OK);
    }
    
    @PostMapping("datos/{idtipo}")//guardar un dato nuevo
    public ResponseEntity<Dato> saveDato(@RequestBody Dato dato,@PathVariable("idtipo") long id){
        
        Dato midato = new Dato();
        midato.setLink(dato.getLink());
        midato.setNumero(dato.getNumero());
        midato.setRutaimagen(dato.getRutaimagen());
        midato.setTexto(dato.getTexto());
        midato.setTipodato(elSuperService.getTipodatobyid(id));
        midato.setTitulo(dato.getTitulo());
       
        return new ResponseEntity<>(elSuperService.saveDato(midato),HttpStatus.OK);
    }
    
    @PostMapping("tipodato")//
    public ResponseEntity<Tipodato> saveTipodato(@RequestBody Tipodato tipodato){
        return new ResponseEntity<>(elSuperService.saveTipodato(tipodato),HttpStatus.CREATED);
    }
    
    @GetMapping("tipodato")//
    public ResponseEntity<List<Tipodato>> getTipodato(@RequestBody Tipodato tipodato){
        return new ResponseEntity<>(elSuperService.getTipoDatos(),HttpStatus.CREATED);
    }
    
    @GetMapping("datos")//devuelve //
    public ResponseEntity<List<Dato>> getAllDatos(){
         
       return new ResponseEntity<>(elSuperService.getAllDatos(),HttpStatus.OK);
    }
     
    @PostMapping("datos/eliminar")//borra por id
    public ResponseEntity<Boolean> deleteDato(@RequestBody EliminarRequest r){
        boolean x = authservice.verificarLog(r.getClave());
        if(x){
            elSuperService.getDatobyid(r.getDato());
            elSuperService.DeleteDatobyid(r.getDato());
            return new ResponseEntity<>(true,HttpStatus.OK);
        }
        return new ResponseEntity<>(false,HttpStatus.OK);
    }
    
    //editarDato
    @PutMapping("datos/editar")
        public ResponseEntity<Dato> editarDato(@RequestBody EditarRequest r){
            boolean x = authservice.verificarLog(r.getClave());
            if(x)return new ResponseEntity<>(elSuperService.editarDato(r.getDato()),HttpStatus.OK);
        return new ResponseEntity<>(elSuperService.getDatobyid(r.getDato().getId() ),HttpStatus.OK);
    }
        

    
     
    
        
        
        
        
        
   
}
