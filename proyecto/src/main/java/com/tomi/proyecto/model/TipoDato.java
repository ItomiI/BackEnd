package com.tomi.proyecto.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Data
@Entity
@Table(name="tipodato")
public class TipoDato {
    
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private long id;
    
   @Column(name = "tipodato", nullable = false)
   private String tipodatos;
 
}


























