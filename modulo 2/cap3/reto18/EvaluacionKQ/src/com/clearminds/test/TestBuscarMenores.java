package com.clearminds.test;

import java.util.ArrayList;

import com.clearminds.componentes.Celda;
import com.clearminds.componentes.Producto;
import com.clearminds.maquina.MaquinaDulces;

public class TestBuscarMenores {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaquinaDulces maquina=new MaquinaDulces();
		maquina.agregarCelda(new Celda("A1"));
        maquina.agregarCelda(new Celda("A2"));
        maquina.agregarCelda(new Celda("B1"));
        maquina.agregarCelda(new Celda("B2"));
        maquina.agregarCelda(new Celda("B3"));
        maquina.agregarCelda(new Celda("B4"));
        
		Producto producto=new Producto("KE34","Papitas",0.85);
		maquina.cargarProducto(producto, "A1", 4);
		
		Producto producto2=new Producto("D456","Doritos1",0.40);
		maquina.cargarProducto(producto2, "A2", 6);
		
		Producto producto3=new Producto("D56546","Doritos2",0.10);
		maquina.cargarProducto(producto3, "B1", 6);
		
		Producto producto4=new Producto("D44565","Doritos3",0.300);
		maquina.cargarProducto(producto4, "B2", 6);
		
		Producto producto5=new Producto("D4885","Doritos4",0.35);
		maquina.cargarProducto(producto5, "B3", 6);
		
		Producto producto6=new Producto("D455","Doritos5",0.25);
		maquina.cargarProducto(producto6, "B41", 6);
		
		
		
		ArrayList<Producto> pro = maquina.buscarMenores(0.50);
		
		System.out.println("Productos menores: "+ pro.size());
		for (Producto p : pro) {
			System.out.println("Nombre: "+ p.getNombre()+" precio: "+ p.getPrecio());
		}
		
		
	}

}
