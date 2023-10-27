package com.krakedev.excepciones;

import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.Logger;

public class ejer3 {
private static final Logger LOGGER= LogManager.getLogger(ejer3.class);


public static void main(String[] args) {
	
	ejer3 ej3 = new ejer3();
	ej3.metodo1();
}


public void metodo1() {
	String a=null;
	try {
		a.substring(3);
		
	} catch (Exception e) {
		System.out.println("error");
		
		LOGGER.error("eroror capturar cadena",e);
	}




}


}
