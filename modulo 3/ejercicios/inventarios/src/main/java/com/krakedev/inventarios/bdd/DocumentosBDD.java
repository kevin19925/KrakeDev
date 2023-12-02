package com.krakedev.inventarios.bdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.krakedev.inventarios.entidades.*;
import com.krakedev.inventarios.excepciones.KrakeDevExeption;
import com.krakedev.inventarios.utils.ConexionBDD;



public class DocumentosBDD {
	
	public ArrayList<Documento> tipo_documentos() throws KrakeDevExeption

	{
		ArrayList<Documento> lista = new ArrayList<Documento>();
		Connection con = null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Documento documento=null;
		try {
			con = ConexionBDD.ontenerConecion();
			ps=con.prepareStatement("select * from tipo_documentos ");
			
			rs=ps.executeQuery();
		
			while (rs.next()) {
				
				documento=new Documento(rs.getString(1), rs.getString(2));
				
				//System.out.println(rs.getString(1));
				lista.add(documento);
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
