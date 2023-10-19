package com.krakedev.Test;

import com.krakedev.Cuadrado;

public class TestCuadrado {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cuadrado obj =  new Cuadrado(3.0);
	
		System.out.println(" Cuadrado con lado de :"+obj.getLado()+ "\n"
				+"area: "+obj.calcularArea()
				+"\nperimetro "+obj.calculaePerimetro());

	}

}
