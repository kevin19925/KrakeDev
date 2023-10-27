package com.cmc.repaso.test;
import com.cmc.repaso.entidades.*;
public class TestProducto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Producto producto1 = new Producto("Laptop", 1000.0);
	        Producto producto2 = new Producto("Telefono", -500.0);

	        System.out.println("Producto 1: Nombre = " + producto1.getNombre() + ", Precio = $" + producto1.getPrecio());
	        System.out.println("Producto 2: Nombre = " + producto2.getNombre() + ", Precio = $" + producto2.getPrecio());

	        double descuento = 10.0;
	        double precioConDescuento = producto1.calcularPrecioPromo(descuento);
	        System.out.println("Precio de " + producto1.getNombre() + " con un descuento del " + descuento + "%: $" + precioConDescuento);
	    
	}

}
