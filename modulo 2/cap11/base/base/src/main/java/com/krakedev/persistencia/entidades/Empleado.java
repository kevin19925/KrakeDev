package com.krakedev.persistencia.entidades;

import java.util.Date;

public class Empleado {
	private int codigo_empleado;
	private String nombre;
	private Date fecha;
	private Date hora;
	private String cedula;

	public Empleado(int codigo_empleado, String nombre, Date fecha, Date hora, String cedula) {
		super();
		this.codigo_empleado = codigo_empleado;
		this.nombre = nombre;
		this.fecha = fecha;
		this.hora = hora;
		this.cedula = cedula;
	}

	public Empleado() {

	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public int getCodigo_empleado() {
		return codigo_empleado;
	}

	public void setCodigo_empleado(int codigo_empleado) {
		this.codigo_empleado = codigo_empleado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Date getHora() {
		return hora;
	}

	public void setHora(Date hora) {
		this.hora = hora;
	}

	@Override
	public String toString() {
		return "Empleado [codigo_empleado=" + codigo_empleado + ", nombre=" + nombre + ", fecha=" + fecha + ", hora="
				+ hora + "]";
	}

}
