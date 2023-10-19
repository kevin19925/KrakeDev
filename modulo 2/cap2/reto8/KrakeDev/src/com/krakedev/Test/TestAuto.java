package com.krakedev.Test;
import com.krakedev.Auto;

public class TestAuto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    Auto auto1 = new Auto( "Ford",2021,2000.0);
        Auto auto2 = new Auto("Chevrolet",2024,3000742.0);


        // Mostrar los valores de los atributos de los dos autos en consola
        System.out.println("Auto 1:");
        System.out.println("Marca: " + auto1.getMarca());
        System.out.println("Año: " + auto1.getAnio());
        System.out.println("Precio: " + auto1.getPrecio());

        System.out.println("\nAuto 2:");
        System.out.println("Marca: " + auto2.getMarca());
        System.out.println("Año: " + auto2.getAnio());
        System.out.println("Precio: " + auto2.getPrecio());
	}

}
