/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tomi.proyecto.auth.service;

import com.tomi.proyecto.auth.model.User;

public interface AuthService {

    
    boolean verificarSiExisteUser(String usuario);
    boolean registrarNuevoUser(User newUser);
    User logearUser(String usuario, String password);
    boolean verificarLog(String clave);


}
