package com.krakedev;


public class TestAuto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    Auto auto1 = new Auto();
        Auto auto2 = new Auto();

        auto1.setMarca( "Ford"); 
        auto1.setAnio(2021);
        auto1.setPrecio(20000.0);

        auto2.setMarca("Chevrolet");
        auto2.setAnio( 20240);
        auto2.setPrecio(30000.0);

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
