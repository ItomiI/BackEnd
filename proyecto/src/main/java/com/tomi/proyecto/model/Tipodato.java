
package com.tomi.proyecto.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;


@Data
@Entity
@Table(name="tipodato")
public class Tipodato {
    
    
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private long id;
    
   @Column(name = "quetipodato", nullable = false)
   private String quetipodato;
   
      

   
   
}
