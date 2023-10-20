package com.cmc.repaso.entidades;

public class Validacion {

	public boolean validarMonto(Double monto) {
		
		if(monto>0) {
			return true;
		}
		return false;
	}
}
