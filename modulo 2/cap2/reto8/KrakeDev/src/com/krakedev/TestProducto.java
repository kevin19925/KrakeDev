package com.krakedev;

public class TestProducto {
	public static void main(String[] args) {
        // Crear 3 variables de tipo Producto: productoA, productoB, productoC
        Producto productoA, productoB, productoC;

        // Instanciar 3 objetos de tipo Producto y referenciar cada uno con una de las variables
        productoA = new Producto();
        productoB = new Producto();
        productoC = new Producto();
        // Modificar los atributos de cada producto con productos de una farmacia
        productoA.nombre = "Paracetamol";
        productoA.descripcion = "Analgésico y antipirético";
        productoA.precio = 4.99;
        productoA.stockActual = 120;

        productoB.nombre = "Shampoo";
        productoB.descripcion = "Shampoo revitalizante para el cabello";
        productoB.precio = 3.99;
        productoB.stockActual = 60;

        productoC.nombre = "Cepillo de dientes";
        productoC.descripcion = "Cepillo de dientes con cerdas suaves";
        productoC.precio = 0.99;
        productoC.stockActual = 90;

        // Mostrar en pantalla los valores de los atributos de los 3 objetos
        System.out.println("Producto A:");
        System.out.println("Nombre: " + productoA.nombre);
        System.out.println("Descripcion: " + productoA.descripcion);
        System.out.println("Precio: $" + productoA.precio);
        System.out.println("Stock Actual: " + productoA.stockActual);

        System.out.println("\nProducto B:");
        System.out.println("Nombre: " + productoB.nombre);
        System.out.println("Descripcion: " + productoB.descripcion);
        System.out.println("Precio: $" + productoB.precio);
        System.out.println("Stock Actual: " + productoB.stockActual);

        System.out.println("\nProducto C:");
        System.out.println("Nombre: " + productoC.nombre);
        System.out.println("Descripcion: " + productoC.descripcion);
        System.out.println("Precio: $" + productoC.precio);
        System.out.println("Stock Actual: " + productoC.stockActual);
    }
}
