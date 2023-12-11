package com.krakedev.inventarios.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.krakedev.inventarios.excepciones.KrakeDevExeption;

public class ConexionBDD {

	public static Connection ontenerConecion() throws KrakeDevExeption {
		
		Context ctx=null;
		DataSource ds=null;
		Connection con=null;
		
			try {
				ctx = new InitialContext();
				ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/ConexionInventario");
				System.out.println(">>>>>>>>>>>>>>>>>>> se conecto");
				// el lookup para llamar JNDI 
				con = ds.getConnection();
			} catch (NamingException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				//relanzo la expecion con mensaje de usuarios 
				// maneja la exepcioj quien utilice este metodo 
				throw new KrakeDevExeption("ERROR de conexion");
			}
			
		
			return con;
	}
	
	
}
