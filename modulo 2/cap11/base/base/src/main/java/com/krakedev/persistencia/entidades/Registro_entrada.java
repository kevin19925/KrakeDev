package com.krakedev.persistencia.entidades;

import java.util.Date;

public class Registro_entrada {
	private int codigo_registro;
	private Date fecha;
	private Date hora;
	private Empleado empleado;
	public Registro_entrada(int codigo_registro, Date fecha, Date hora, Empleado empleado) {
		super();
		this.codigo_registro = codigo_registro;
		this.fecha = fecha;
		this.hora = hora;
		this.empleado = empleado;
	}
	public Registro_entrada() {
		super();
	}
	public int getCodigo_registro() {
		return codigo_registro;
	}
	public void setCodigo_registro(int codigo_registro) {
		this.codigo_registro = codigo_registro;
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
	public Empleado getEmpleado() {
		return empleado;
	}
	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
	@Override
	public String toString() {
		return "registro_entrada [codigo_registro=" + codigo_registro + ", cedula_empleado=" 
				+ ", fecha=" + fecha + ", hora=" + hora + ", empleado=" + empleado + "]";
	}
	
	
	
}
