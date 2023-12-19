package com.krakedev.inventarios.bdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.krakedev.inventarios.entidades.Pedido;
import com.krakedev.inventarios.excepciones.KrakeDevExeption;
import com.krakedev.inventarios.utils.ConexionBDD;


public class PedidosBDD {
	
	
	public void insertar(Pedido pedido) throws KrakeDevExeption

	{
	
		Connection con = null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		Date fechaActual = new Date();

        
        java.sql.Date fechaSQL = new java.sql.Date(fechaActual.getTime());
        
		try { 
			con = ConexionBDD.ontenerConecion();
			ps=con.prepareStatement("INSERT INTO public.cabecera_pedido ( "
					+ "	 proveedor, fecha, estado) "
					+ "	VALUES ( ?, ?, ?);");

			
			ps.setString(1,pedido.getProveedor().getIdentificador());
			ps.setDate(2, fechaSQL);
			ps.setString(2, "R");
			ps.executeUpdate();
		
			
			
			
			
		} catch (KrakeDevExeption e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new KrakeDevExeption("Error al insertar producto " +e.getMessage());
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println("inseretar producto>>>>>>"+ps);
		}
		
		
	}
}
