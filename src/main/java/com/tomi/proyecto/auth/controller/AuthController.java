package com.tomi.proyecto.auth.controller;
import com.tomi.proyecto.auth.DTO.Usuario;
import com.tomi.proyecto.auth.model.User;
import com.tomi.proyecto.auth.service.AuthService;
import com.tomi.proyecto.metodos.Metodos;
import java.util.ArrayList;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "https://portfolio-28276.web.app/")
@RestController
@RequestMapping("auto")
public class AuthController {
    
    private final  AuthService authservice;
    private final Metodos encripter;
    
    public AuthController(AuthService authservice) {
        super();
        this.authservice = authservice;
        this.encripter = new Metodos();
    }
    
    /*@PostMapping("registrar")
    public ResponseEntity<Boolean> Registrar(@RequestBody User usuario){
        boolean verif = authservice.verificarSiExisteUser(usuario.getUsuario());
        if(!verif){
            authservice.registrarNuevoUser(usuario);
            return new ResponseEntity<>(true,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(false,HttpStatus.OK);
        }
        
    }*/
    
    @PostMapping("logear")
    public ResponseEntity<String[]> Logear(@RequestBody(required = true) Usuario user){
        boolean verif = authservice.verificarSiExisteUser(user.getUsuario());
        String hola[] = new String[2];
        if(verif){
            try {
                User a = authservice.logearUser(user.getUsuario(), user.getContra());
                ArrayList<String> s = new ArrayList<>();
                s.add(a.getUsuario());
                s.add(a.getContra());
                String str = encripter.Encriptar(s, 13);
                hola[0] = str;
                hola[1] = a.getNombre();
                return new ResponseEntity<>(hola,HttpStatus.OK);
                
            } catch (Exception e) {
               return new ResponseEntity<>(hola,HttpStatus.OK);
            }
    
        }else{
            return new ResponseEntity<>(hola,HttpStatus.OK);
        }
    }
    
    @PostMapping("verif")
    public  ResponseEntity<Boolean> vef(String r ){
        boolean x = authservice.verificarLog(r);
        return  new ResponseEntity<>(x,HttpStatus.OK);
        
    }//authservice.getUser(usuario.getUsuario(), usuario.getPassword())
    
 
}