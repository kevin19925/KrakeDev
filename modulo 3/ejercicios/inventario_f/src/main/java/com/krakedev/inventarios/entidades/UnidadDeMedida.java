package com.krakedev.inventarios.entidades;

public class UnidadDeMedida {
private String codigo;
private String descripcion;
 private Categoria_unidad_medida categoria_udm;
public UnidadDeMedida(String codigo, String descripcion, Categoria_unidad_medida categoria_udm) {
	super();
	this.codigo = codigo;
	this.descripcion = descripcion;
	this.categoria_udm = categoria_udm;
}
public UnidadDeMedida(String codigo, String descripcion) {
	super();
	this.codigo = codigo;
	this.descripcion = descripcion;
	
}
public UnidadDeMedida() {

}

public String getCodigo() {
	return codigo;
}
public void setCodigo(String codigo) {
	this.codigo = codigo;
}
public String getDescripcion() {
	return descripcion;
}
public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
}
public Categoria_unidad_medida getCategoria_udm() {
	return categoria_udm;
}
public void setCategoria_udm(Categoria_unidad_medida categoria_udm) {
	this.categoria_udm = categoria_udm;
}
@Override
public String toString() {
	return "UnidadDeMedida [codigo=" + codigo + ", descripcion=" + descripcion + "]";
}
 
 
}
