package com.krakedev.persistencia.test;

import java.util.ArrayList;

import com.krakedev.persistencia.entidades.Empleado;
import com.krakedev.persistencia.servicios.Admin_registro;

public class testconsultaEmpleado {

	public static void main(String[] args) {
	try {
		ArrayList <Empleado > empleados = Admin_registro.buscarNombres("a");
		System.out.println(empleados);
		
		System.out.println("-----busqueda pk--------");
		System.out.println(Admin_registro.buscarcodigo(1));
	} catch (Exception e) {
		System.out.println(e.getMessage());
	}
	
	}

}
