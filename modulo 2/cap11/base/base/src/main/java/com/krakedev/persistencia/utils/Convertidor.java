package com.krakedev.persistencia.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.events.EventException;

public class Convertidor {
	private static final String FORMATO_FECHA = "yyyy/MM/dd";
	private static final String FORMATO_HORA = "hh:mm";
	private static final Logger LOGGER = LogManager.getLogger(ConexionBDD.class);
	
	public static Date convertidorADate(String fechaStr) throws Exception {
		Date fecha = null;
		SimpleDateFormat sdf = new SimpleDateFormat(FORMATO_FECHA);
		try {
			fecha = sdf.parse(fechaStr);
			LOGGER.debug("fecha convitiendo "+fechaStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			LOGGER.error(""+e);
			throw new Exception("la fecha no teien fomrato correcto");
		}

		return fecha;
	}

	public static Date convertidorHora(String fechaStr) throws Exception {
		Date fecha = null;
		SimpleDateFormat sdf = new SimpleDateFormat(FORMATO_HORA);
		try {
			fecha = sdf.parse(fechaStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			LOGGER.error(""+e);
			throw new Exception("la fecha no teien fomrato correcto");
		}

		return fecha;
	}

}
