package com.exampel.examenMiniblogsModel;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@Override
	public String toString() {
		return "Rol [id=" + id + ", nombre=" + nombre + "]";
	}
	public Rol(Long id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

    // Getters y Setters
    
}

