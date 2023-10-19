package com.krakedev.Test;

import com.krakedev.Rectangulo;

public class TestRectangulo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

Rectangulo rec1 =  new Rectangulo(2,4);

System.out.println("Perimetro del rectangulo con:"
		+ "\n base "+rec1.getBase()+" \n altura " +rec1.getAltura()+"\n es  " +rec1.calculaePerimetro());

	}

}
