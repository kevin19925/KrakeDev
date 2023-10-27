package com.krakedev.excepciones;

import java.io.File;
import java.io.IOException;

public class ejer1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("inicio");
		String a= null;
		try {
			a.substring(3);
			System.out.println("fin");
		} catch (Exception e) {
			System.out.println("cach");
		}
		finally {
			System.out.println("finaly");
		}
	
		System.out.println("fuera cach");
	}

	
	public void metodo1() {
	String a=null;
	a. substring(0);
	//NPE Unchecked
	}
	public void metodo2() {
//	File  f =new File("archivol.txt");
	//f.createNewFile(); //IOException - CHECKED
	//se debe contolar obligatorio el checked
	}
	
	// solicion 1
	
	public void metodo3() {
		File  f =new File("archivol.txt");
		try {
			f.createNewFile(); //IOException - CHECKED
		} catch (IOException io) {
			// TODO: handle exception
		}

		}
	
	
	// solucion 2
	//PROPAGO ECXEPCION
	public void metodo4()throws IOException {
		File  f =new File("archivol.txt");
	
			f.createNewFile(); //IOException - CHECKED
		
		
			
		}
	// el metodo5 se hace cargo de la excepcion 
	public void metodo5(){
	//	metodo4();
	}
	
	
}
