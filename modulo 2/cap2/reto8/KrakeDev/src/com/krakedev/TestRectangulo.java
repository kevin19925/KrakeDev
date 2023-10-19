package com.krakedev;

public class TestRectangulo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

Rectangulo rec1 =  new Rectangulo();
rec1.setBase(2);
rec1.setAltura(4);

System.out.println("Perimetro del rectangulo con:"
		+ "\n base "+rec1.getBase()+" \n altura " +rec1.getAltura()+"\n es  " +rec1.calculaePerimetro());

	}

}
