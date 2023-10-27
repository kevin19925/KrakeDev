package com.cmd.evaluacion.test;

import com.cmd.evaluacion.*;

public class TestImpresion {
	public static void main(String[] args) {

	Cuota cuota = new Cuota(1);
	cuota.setCuota(44.24);
	cuota.setCapital(5000);
	cuota.setInteres(50);
	cuota.setAbonoCapital(394.24134);
	cuota.setSaldo(4605.76);
	
	cuota.mostrarPréstamo();
	}
}
