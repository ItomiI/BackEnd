package com.tomi.proyecto.auth.controller;

import com.tomi.proyecto.auth.model.User;
import com.tomi.proyecto.auth.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("auto")
public class AuthController {
    

    private final  AuthService authservice;

    public AuthController(AuthService authservice) {
        super();
        this.authservice = authservice;
    }
    
    @GetMapping("hola")
    public ResponseEntity<String> aawrbwabr (){
        return new ResponseEntity<>("hola",HttpStatus.OK);
    }
    
    
    
    @PostMapping("registrar")
    public ResponseEntity<String> Registrar(@RequestBody User usuario){
        String registro = authservice.newUser(usuario.getNombre(), usuario.getContra(),usuario.getMailnose());
        switch (registro) {
            case "ya existe" -> {
                return new ResponseEntity<>(registro,HttpStatus.BAD_REQUEST);
            }
            case "registrado!" -> {
                return new ResponseEntity<>(registro,HttpStatus.OK);
            }
                
        }
         return new ResponseEntity<>("quwe",HttpStatus.OK);
    }
    
    @PostMapping("logear")
    public ResponseEntity<String> Logear(){
        
        
        return new ResponseEntity<>("quwe",HttpStatus.OK);
    }
    
    
    
    //authservice.getUser(usuario.getUsuario(), usuario.getPassword())
    
    
    
    
    
    
    
    
    
}
