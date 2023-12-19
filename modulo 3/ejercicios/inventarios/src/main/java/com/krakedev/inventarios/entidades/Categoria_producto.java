package com.krakedev.inventarios.entidades;

public class Categoria_producto {
	private int codigo;
	private String nombre;

	public Categoria_producto(int codigo, String nombre) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
	
	}

	public Categoria_producto() {
		
	}



	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Categoria_producto [codigo=" + codigo + ", nombre=" + nombre + "]";
	}


	
	
}

