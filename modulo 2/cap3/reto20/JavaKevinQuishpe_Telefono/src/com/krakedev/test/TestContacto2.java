package com.krakedev.test;

import com.krakedev.evaluacion.Contacto;
import com.krakedev.evaluacion.Direccion;

public class TestContacto2 {

	public static void main(String[] args) {
	    // Crear una instancia de Direccion
        Direccion direccion = new Direccion("Av. siempre Viva", "Calle 4");

        // Crear una instancia de Contacto
        Contacto contacto = new Contacto("1234567890", "Juan", "Pérez", direccion);

        // Mostrar información usando el método imprimir
        System.out.println("Información del Contacto:");
        contacto.imprimir();

        // Modificar valores usando los métodos setters
        contacto.setCedula("9876543210");
        contacto.setNombre("Ana");
        contacto.setApellido("Gómez");

        // Modificar la dirección
        Direccion nuevaDireccion = new Direccion("Cdl del ejercito", "Pasaje 2B");
        contacto.setDireccion(nuevaDireccion);

        // Mostrar información actualizada
        System.out.println("\nInformación del Contacto (actualizada):");
        contacto.imprimir();
    }
	}

