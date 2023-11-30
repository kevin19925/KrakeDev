package com.krakedev.entidades;

public class Cliente {
String cedula;
String nombre;
int hijos;


public Cliente(String cedula, String nombre) {
	super();
	this.cedula = cedula;
	this.nombre = nombre;
}



public Cliente(String cedula, String nombre, int hijos) {
	super();
	this.cedula = cedula;
	this.nombre = nombre;
	this.hijos = hijos;
}



public int getHijos() {
	return hijos;
}



public void setHijos(int hijos) {
	this.hijos = hijos;
}



public Cliente() {
	super();
}


public String getCedula() {
	return cedula;
}
public void setCedula(String cedula) {
	this.cedula = cedula;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}


@Override
public String toString() {
	return "Cliente [cedula=" + cedula + ", nombre=" + nombre + "]";
}



	
}
