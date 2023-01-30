/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tomi.proyecto.auth.service.impl;

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
    public User getUser(String nombree, String password) {
        User usuario = userRepository.buscarUser(password, nombree).orElseThrow(()-> 
            new ResourceNotFoundException("usuario","usuario",nombree+" "+password));
        
    return usuario;
      
    } 

    @Override
    public String newUser(String username, String password, String mail) {
        User a;
        try {
            a = userRepository.verificarUser(username).orElseThrow(()-> 
            new ResourceNotFoundException("usuario","usuario",username+" "+password));
            return "ya existe";
        } catch (ResourceNotFoundException e) {
             User newuser = new User();
            newuser.setContra(password);
            newuser.setNombre(username);
            newuser.setMailnose(mail);
            userRepository.save(newuser);
            return "registrado!";
        }    
    }
    
    
    
    
    
    
}
