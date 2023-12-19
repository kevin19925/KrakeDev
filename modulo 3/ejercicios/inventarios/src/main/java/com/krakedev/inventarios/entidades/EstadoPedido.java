package com.krakedev.inventarios.entidades;

public class EstadoPedido {
private String codigo;
private String descricion;
public String getCodigo() {
	return codigo;
}
public void setCodigo(String codigo) {
	this.codigo = codigo;
}
public String getDescricion() {
	return descricion;
}
public void setDescricion(String descricion) {
	this.descricion = descricion;
}
public EstadoPedido(String codigo, String descricion) {
	super();
	this.codigo = codigo;
	this.descricion = descricion;
}
public EstadoPedido() {
 
}

}
