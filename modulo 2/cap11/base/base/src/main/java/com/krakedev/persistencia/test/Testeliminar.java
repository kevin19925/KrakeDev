package com.krakedev.persistencia.test;

import java.util.Date;

import com.krakedev.persistencia.entidades.Empleado;
import com.krakedev.persistencia.entidades.Registro_entrada;
import com.krakedev.persistencia.servicios.Admin_registro;
import com.krakedev.persistencia.utils.Convertidor;

public class Testeliminar {
	public static void main(String[] args) {
		try {
			Date fecha = Convertidor.convertidorADate("2020/02/1");
			Date hora = Convertidor.convertidorHora("12:30");
			Empleado em = new Empleado(20, "Juan", fecha, hora, "1010101012");
			Admin_registro.eliminar(new Registro_entrada(30, fecha, hora, em));

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
// debug simple
		// trace mas detallado 
	}
}
