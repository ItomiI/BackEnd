/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tomi.proyecto.auth.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="Usuario")
public class User {
    
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @Column(name = "nombre", nullable = false)
    private String nombre;
   @Column(name = "usuario", nullable = false)
    private String usuario;
   
    @Column(name = "contra", nullable = false)
    private String contra;
     
    @Column(name = "mailnose", nullable = false)
    private String mailnose;
   
 

   
   
}
