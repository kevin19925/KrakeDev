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
        productoA.setDescripcion("Analgésico y antipirético");
        productoA.setNombre("Paracetamol");
        productoA.setPrecio(4.99);
        productoA.setStockActual(120);

        productoB.setNombre("Shampoo");
        productoB.setDescripcion("Shampoo revitalizante para el cabello");
        productoB.setPrecio(3.99);
        productoB.setStockActual(60);

        productoC.setNombre("Cepillo de dientes");
        productoC.setDescripcion("Cepillo de dientes con cerdas suaves");
        productoC.setPrecio(0.99);
        productoC.setStockActual(90);

        // Mostrar en pantalla los valores de los atributos de los 3 objetos
        System.out.println("Producto A:");
        System.out.println("Nombre: " + productoA.getNombre());
        System.out.println("Descripcion: " + productoA.getDescripcion());
        System.out.println("Precio: $" + productoA.getPrecio());
        System.out.println("Stock Actual: " + productoA.getStockActual());

        System.out.println("\nProducto B:");
        System.out.println("Nombre: " + productoB.getNombre());
        System.out.println("Descripcion: " + productoB.getDescripcion());
        System.out.println("Precio: $" + productoB.getPrecio());
        System.out.println("Stock Actual: " + productoB.getStockActual());

        System.out.println("\nProducto C:");
        System.out.println("Nombre: " + productoC.getNombre());
        System.out.println("Descripcion: " + productoC.getDescripcion());
        System.out.println("Precio: $" + productoC.getPrecio());
        System.out.println("Stock Actual: " + productoC.getStockActual());
    }
}
