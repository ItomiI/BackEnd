package com.tomi.proyecto.model;

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
    @Column(name = "texto", nullable = true)
    private String texto;
    @Column(name = "link", nullable = true)
    private String link;
    @Column(name = "numero", nullable = true)
    private int numero;
    @ManyToOne(fetch = FetchType.EAGER,optional = false)
    @JoinColumn(name="tipodato_id", nullable=false)
    private TipoDato tipodato;
    
    public Dato(){}
    public Dato(String texto, String rutaimagen,TipoDato tipodato){
        this.texto = texto;
        this.rutaimagen = rutaimagen;
        this.tipodato = tipodato;
    }
    public Dato(String titulo, String texto, String rutaimagen,TipoDato tipodato){
        this.titulo = titulo;
        this.texto = texto;
        this.rutaimagen = rutaimagen;
        this.tipodato = tipodato;
    }
    public Dato(String titulo, int numero,TipoDato tipodato){
        this.numero = numero;
        this.titulo = titulo;
        this.tipodato = tipodato;
    }
    public Dato(String titulo, String texto, String rutaimagen, String link,TipoDato tipodato){
        this.titulo = titulo;
        this.texto = texto;
        this.rutaimagen = rutaimagen;
        this.link = link;
        this.tipodato = tipodato;        
    }
    
}
