package com.cmc.repaso.test;
import com.cmc.repaso.entidades.*;

public class TestItem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	     Item producto1 = new Item("Producto A");
	        producto1.setProductosActuales(20);

	        System.out.println("Valores iniciales para Producto A:");
	        producto1.imprimir();

	        producto1.vender(5);
	        System.out.println("Despues de vender 5 productos:");
	        producto1.imprimir();

	        producto1.devolver(3);
	        System.out.println("Despues de devolver 3 productos:");
	        producto1.imprimir();

	        Item producto2 = new Item("Producto B");
	        producto2.setProductosActuales(20);

	        System.out.println("\nValores iniciales para Producto B:");
	        producto2.imprimir();

	        producto2.vender(10);
	        System.out.println("Despues de vender 10 productos:");
	        producto2.imprimir();

	        producto2.devolver(7);
	        System.out.println("Despues de devolver 7 productos:");
	        producto2.imprimir();
	}

}
