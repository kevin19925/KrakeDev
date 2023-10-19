package com.krakedev.demo.test;
import com.krakedev.demo.*;
public class TestProducto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Producto proc1 = new Producto(12, "Pan");
		proc1.setDescripcion("pan integral");
		proc1.setPeso(20);
		
		System.out.println("producto: "+proc1.getNombre());
		System.out.println("id: "+proc1.getCodigo());
		System.out.println("descripcion: "+proc1.getDescripcion());
		System.out.println("peso: "+proc1.getPeso());
		
	}

}
