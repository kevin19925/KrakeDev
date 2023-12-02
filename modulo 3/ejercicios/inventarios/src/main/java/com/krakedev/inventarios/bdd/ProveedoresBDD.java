package com.krakedev.inventarios.bdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.krakedev.inventarios.entidades.Proveedor;
import com.krakedev.inventarios.excepciones.KrakeDevExeption;
import com.krakedev.inventarios.utils.ConexionBDD;



public class ProveedoresBDD {
	
	public ArrayList<Proveedor> buscar(String subcadena) throws KrakeDevExeption

	{
		ArrayList<Proveedor> lista = new ArrayList<Proveedor>();
		Connection con = null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Proveedor proveedor=null;
		try {
			con = ConexionBDD.ontenerConecion();
			ps=con.prepareStatement("select * from proveedores where upper(nombre) like ?");
			ps.setString(1,"%" +subcadena.toUpperCase()+"%");
			rs=ps.executeQuery();
		
			while (rs.next()) {
				
				proveedor=new Proveedor(rs.getString(1), rs.getString("tipo_documento"),rs.getString("nombre"),rs.getString("telefono"),rs.getString("correo"),rs.getString("direccion"));
				
				//System.out.println(rs.getString(1));
				lista.add(proveedor);
			}
			
			
		} catch (KrakeDevExeption e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new KrakeDevExeption("Error al consultar detalle: " +e.getMessage());
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return lista;

	}
}
