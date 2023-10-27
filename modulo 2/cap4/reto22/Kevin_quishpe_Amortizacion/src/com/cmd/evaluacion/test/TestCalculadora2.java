package com.cmd.evaluacion.test;

import com.cmd.evaluacion.*;

public class TestCalculadora2 {
																																																																																			
	    public static void main(String[] args) {
	        Prestamo prestamo = new Prestamo(5000, 12, 15);

	        CalculadoraAmortizacion.generarTabla(prestamo);
	        CalculadoraAmortizacion.mostrarTabla(prestamo);
	    }
	}