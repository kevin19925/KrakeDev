package com.krakedev;

public class TestCuadrado {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cuadrado obj =  new Cuadrado();
		obj.lado=3;
	
		System.out.println(" Cuadrado con lado de :"+obj.lado+ "\n"
				+"area: "+obj.calcularArea()
				+"\nperimetro "+obj.calculaePerimetro());

	}

}
