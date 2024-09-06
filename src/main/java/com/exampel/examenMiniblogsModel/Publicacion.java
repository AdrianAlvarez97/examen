package com.exampel.examenMiniblogsModel;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Publicacion {
	   @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private String titulo;
	    private String contenido;

	    @ManyToOne
	    private Usuario autor;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getTitulo() {
			return titulo;
		}

		public void setTitulo(String titulo) {
			this.titulo = titulo;
		}

		public String getContenido() {
			return contenido;
		}

		public void setContenido(String contenido) {
			this.contenido = contenido;
		}

		public Usuario getAutor() {
			return autor;
		}

		public void setAutor(Usuario autor) {
			this.autor = autor;
		}

		public Publicacion(Long id, String titulo, String contenido, Usuario autor) {
			super();
			this.id = id;
			this.titulo = titulo;
			this.contenido = contenido;
			this.autor = autor;
		}

		public Publicacion() {
			super();
			// TODO Auto-generated constructor stub
		}

	    // Getters y Setters
	    
}
