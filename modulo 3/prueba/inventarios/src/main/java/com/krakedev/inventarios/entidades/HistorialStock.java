package com.krakedev.inventarios.entidades;

import java.util.Date;

public class HistorialStock {
	private int codigo;
	private Date fecha;
	private String referencia;
	private Producto producto;
	private int cantidad;
	
	public int getCodigo() {
		return codigo;
	}
	public Date getFecha() {
		return fecha;
	}
	public String getReferencia() {
		return referencia;
	}
	public Producto getProducto() {
		return producto;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
}
