package com.tomi.proyecto.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import org.springframework.http.ResponseEntity;

@Data
@Entity
@Table(name = "superdatos")
public class Dato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @Column(name = "titulo", nullable = true)
    private String titulo;
    
    @Column(name = "rutaimagen", nullable = true)
    private String rutaimagen;
    
    @Column(name = "texto", nullable = true,length = 1500)
    private String texto;
    
    @Column(name = "link", nullable = true)
    private String link;
    
    @Column(name = "numero", nullable = true)
    private int numero;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tipodatoid",referencedColumnName = "id",nullable = true)
    private Tipodato tipodato;
    

}
