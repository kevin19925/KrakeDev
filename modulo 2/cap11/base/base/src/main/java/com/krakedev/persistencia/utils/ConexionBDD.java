package com.krakedev.persistencia.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.krakedev.persistencia.servicios.Admin_registro;

public class ConexionBDD {
	// se hace estatico por que puedo utilizar desde cualquier lugar sin intanciar
	private static final String DRIVER = "org.postgresql.Driver";
	private static String URL = "jdbc:postgresql://localhost:5432/db_reto24";
	private static String USUARIO = "postgres";
	private static String CLAVE = "POLIkevin1";
	private static final Logger LOGGER = LogManager.getLogger(ConexionBDD.class);
	public static Connection conectar() throws Exception {
		Connection connection = null;

		try {
			Class.forName(DRIVER);
			connection = DriverManager.getConnection(URL, USUARIO, CLAVE);
			LOGGER.debug("conexion exitosaaa");

		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
			LOGGER.error(e);
			throw new Exception("eroro en l ainfrestuctura ");
		}

		return connection;
	}

}
