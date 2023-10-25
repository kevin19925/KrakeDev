package com.clearminds.test;

import com.clearminds.componentes.*;

public class TestCelda {
	public static void main(String[] args) {
		Celda celda=new Celda("A1");
		//linea 9  la variable  producto 
		System.out.println(celda.getProducto().getNombre());
		
		System.out.println("CELDA:"+celda.getProducto());
		System.out.println("Nombre Producto:"+celda.getProducto().getNombre());
		System.out.println("Precio Producto:"+celda.getProducto().getPrecio());
		System.out.println("C�digo Producto:"+celda.getProducto().getCodigo());
		System.out.println("STOCK:"+celda.getStock());
		System.out.println("*************************************");
	}
}
