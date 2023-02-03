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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AuthServiceImpl  implements AuthService{
    
    @Autowired()
    private UserRepository userRepository;
    
    
    @Override
    public boolean verificarSiExisteUser(String usuario){
        User a = userRepository.verSiExisteUser(usuario).orElse(null);
        return a!=null;
    }
    
    @Override
    public boolean registrarNuevoUser(User newUser) {
        
        User a = userRepository.save(newUser);
        return true;
    }
    
   @Override
    public User logearUser(String nombree, String password) {
        User usuario = userRepository.Logear(nombree, password).orElseThrow(()-> 
            new ResourceNotFoundException("usuario","usuario",nombree+" "+password));
        
    return usuario;
      
    } 

    @Override
    public boolean verificarLog(String usuario, String password) {
         try {
            User u = userRepository.Logear(usuario, password).orElseThrow(()-> 
            new ResourceNotFoundException("usuario","usuario",usuario+" "+password));
             return true;
        } catch (Exception e) {
            return false;
        }
        
    }

   

  
  
    
    
    
    
    
    
}
