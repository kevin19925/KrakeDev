package com.krakedev.inventarios.entidades;

public class Categoria_producto {
	private int codigo;
	private String nombre;
	private int codigo_padre;
	public Categoria_producto(int codigo, String nombre) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
	
	}

	
	
	public Categoria_producto(int codigo, String nombre, int codigo_padre) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.codigo_padre = codigo_padre;
	}



	public int getCodigo_padre() {
		return codigo_padre;
	}


	public void setCodigo_padre(int codigo_padre) {
		this.codigo_padre = codigo_padre;
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
		return "Categoria_producto [codigo=" + codigo_padre + ", nombre=" + nombre + "]";
	}


	
	
}

