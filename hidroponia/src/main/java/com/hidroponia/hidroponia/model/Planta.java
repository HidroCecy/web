package com.hidroponia.hidroponia.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Planta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String tipo;
    private String fechaSiembra;
    private double nivelNutrientes;

    public Planta() {}

    public Planta(String nombre, String tipo, String fechaSiembra, double nivelNutrientes) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.fechaSiembra = fechaSiembra;
        this.nivelNutrientes = nivelNutrientes;
    }

    // Getters y setters
    public Long getId() { return id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public String getFechaSiembra() { return fechaSiembra; }
    public void setFechaSiembra(String fechaSiembra) { this.fechaSiembra = fechaSiembra; }

    public double getNivelNutrientes() { return nivelNutrientes; }
    public void setNivelNutrientes(double nivelNutrientes) { this.nivelNutrientes = nivelNutrientes; }
}
