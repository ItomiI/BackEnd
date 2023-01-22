package com.tomi.proyecto.controller;

import com.tomi.proyecto.model.Dato;
import com.tomi.proyecto.model.TipoDato;
import com.tomi.proyecto.service.DatoService;
import com.tomi.proyecto.service.TipoDatoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class DatoController {
    
    private DatoService datoService;
        
    private TipoDatoService tipoDatoService;
    public DatoController(DatoService datoService,TipoDatoService tipoDatoService) {
        super();
        this.datoService = datoService;
        this.tipoDatoService = tipoDatoService;
    }
    
    
    @PostMapping("datos")
    public ResponseEntity<Dato> saveDato(@RequestBody Dato dato){
        return new ResponseEntity<>(datoService.saveDato(dato),HttpStatus.CREATED);
    }
    
    @PostMapping("tipodatos")
    public ResponseEntity<TipoDato> saveTipoDato(@RequestBody TipoDato tipodato){
        return new ResponseEntity<>(tipoDatoService.saveTipoDato(tipodato),HttpStatus.CREATED);
    }
    @GetMapping("tipodatos")
     public String a(){
        return "hola tipodatos";
    }
      @GetMapping("datos")
     public String b(){
        return "hola datos";
    }
}
