package com.krakedev;


public class TestAuto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    Auto auto1 = new Auto();
        Auto auto2 = new Auto();

        auto1.marca = "Ford";
        auto1.anio = 2021;
        auto1.precio = 20000.0;

        auto2.marca = "Chevrolet";
        auto2.anio = 2024;
        auto2.precio = 30000.0;

        // Mostrar los valores de los atributos de los dos autos en consola
        System.out.println("Auto 1:");
        System.out.println("Marca: " + auto1.marca);
        System.out.println("Año: " + auto1.anio);
        System.out.println("Precio: " + auto1.precio);

        System.out.println("\nAuto 2:");
        System.out.println("Marca: " + auto2.marca);
        System.out.println("Año: " + auto2.anio);
        System.out.println("Precio: " + auto2.precio);
	}

}
