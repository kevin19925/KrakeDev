package com.krakedev;

public class TestRectangulo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

Rectangulo rec1 =  new Rectangulo();
rec1.altura=2;
rec1.base=4;

System.out.println("Perimetro del rectangulo con:"
		+ "\n base "+rec1.base+" \n altura " +rec1.altura +"\n es  " +rec1.calculaePerimetro());

	}

}
