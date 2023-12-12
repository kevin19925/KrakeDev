package com.krakedev.inventarios.entidades;

public class Categoria_unidad_medida {
	private int categoria;
	private String nombre;
	
	public Categoria_unidad_medida(int categoria, String nombre) {
		super();
		this.categoria = categoria;
		this.nombre = nombre;
		
	}
	



	public int getCategoria() {
		return categoria;
	}


	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	
}
