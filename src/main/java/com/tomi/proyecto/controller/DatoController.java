package com.tomi.proyecto.controller;



import com.tomi.proyecto.auth.service.AuthService;
import com.tomi.proyecto.metodos.Metodos;
import com.tomi.proyecto.model.Dato;
import com.tomi.proyecto.model.Tipodato;
import com.tomi.proyecto.service.MiService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200/")
//@CrossOrigin(origins = "https://portfolio-28276.web.app/")
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
        if(id==1)return new ResponseEntity<>(dato,HttpStatus.BAD_REQUEST);
        dato.setTipodato(elSuperService.getTipodatobyid(id));
        return new ResponseEntity<>(elSuperService.saveDato(dato),HttpStatus.OK); 
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
     
    @DeleteMapping("datos/eliminar/{id}")//borra por id
    public ResponseEntity<Boolean> deleteDato(@PathVariable("id") long id,@RequestHeader(value="clave") String clave){
        boolean x = authservice.verificarLog(clave);
        if(x){
            elSuperService.DeleteDatobyid(id);
            return new ResponseEntity<>(true,HttpStatus.OK);
        }
        return new ResponseEntity<>(false,HttpStatus.OK);
    }
    
    @PutMapping("datos/editar")
        public ResponseEntity<Dato> editarDato(@RequestBody Dato dato ,@RequestHeader(value="clave") String clave){
            boolean x = authservice.verificarLog(clave);
            if(x)return new ResponseEntity<>(elSuperService.editarDato(dato),HttpStatus.OK);
        return new ResponseEntity<>(elSuperService.getDatobyid(dato.getId() ),HttpStatus.OK);
    }
        
    @PostMapping("hola")
    public ResponseEntity<String> hola(@RequestHeader(value="clave") String clave){
        return new ResponseEntity<>(clave,HttpStatus.OK);
    }
    
     
    
        
        
        
        
        
   
}
