package com.cmc.repaso.test;

import com.cmc.repaso.entidades.Estudiante;

public class TestEstudiante {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		   Estudiante estudiante1 = new Estudiante("Juan");
	        Estudiante estudiante2 = new Estudiante("Maria");

	        estudiante1.calificar(7.5);
	        estudiante2.calificar(8.2);

	        System.out.println(estudiante1.getNombre() + ": Nota = " + estudiante1.getNota() + ", Resultado = " + estudiante1.getResultado());
	        System.out.println(estudiante2.getNombre() + ": Nota = " + estudiante2.getNota() + ", Resultado = " + estudiante2.getResultado());
	}

}
