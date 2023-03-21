/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tomi.proyecto.auth.service.impl;

import com.tomi.proyecto.auth.DTO.Usuario;
import com.tomi.proyecto.auth.model.User;
import com.tomi.proyecto.auth.repository.UserRepository;
import com.tomi.proyecto.auth.service.AuthService;
import com.tomi.proyecto.exception.ResourceNotFoundException;
import com.tomi.proyecto.metodos.Metodos;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AuthServiceImpl  implements AuthService{
    
    @Autowired()
    private UserRepository userRepository;
    private final Metodos encripter = new Metodos();
    
    @Override
    public boolean verificarSiExisteUser(String usuario){
        return userRepository.verSiExisteUser(usuario).isPresent();
    }
    
    @Override
    public boolean registrarNuevoUser(User newUser) {
        userRepository.save(newUser);
        return true;
    }
    
   @Override
    public User logearUser(String nombree, String password) {
        User usuario = userRepository.Logear(nombree, password).orElseThrow(()-> 
            new ResourceNotFoundException("usuario o pass","usuario o pass", nombree+" "+password));
        return usuario;
      
    } 

    @Override
    public boolean verificarLog(String clave) {
        ArrayList<String> p = encripter.DesEncriptar(clave,13);
            String usuario = p.get(0);
            String password = p.get(1);
         try {
            User u = userRepository.Logear(usuario, password).orElseThrow(()-> 
            new ResourceNotFoundException("usuario","usuario",usuario+" "+password));
            return true;
        } catch (Exception e) {
            return false;
        }
        
    }

   

  
  
    
    
    
    
    
    
}
