package com.krakedev.inventarios.bdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.krakedev.inventarios.entidades.Producto;
import com.krakedev.inventarios.entidades.Proveedor;
import com.krakedev.inventarios.entidades.TipoDocumento;
import com.krakedev.inventarios.excepciones.KrakeDevException;
import com.krakedev.inventarios.utils.ConexionBDD;



public class TipoDocumentoBDD {
	public ArrayList<TipoDocumento> obtenerTodos() throws KrakeDevException{
		ArrayList<TipoDocumento> tiposDocumento=new ArrayList<TipoDocumento>();
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		TipoDocumento tipoDocumento=null;
		try {
			con=ConexionBDD.obtenerConexion();
			ps=con.prepareStatement("select codigo,descripcion "
					+ "from tipo_documentos ");
			rs=ps.executeQuery();
			
			while(rs.next()) {
				String codigo=rs.getString("codigo");
				String descripcion=rs.getString("descripcion");
				tipoDocumento=new TipoDocumento(codigo,descripcion);
				tiposDocumento.add(tipoDocumento);
			}
		} catch (KrakeDevException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new KrakeDevException("Error al consultar. Detalle:"+e.getMessage());
		}
		return tiposDocumento;
	}
	
	public void insertar(TipoDocumento td) throws KrakeDevException{
		Connection con=null;
		PreparedStatement ps=null;
		try {
			con=ConexionBDD.obtenerConexion();
			ps=con.prepareStatement("insert into tipo_documentos (codigo, descripcion)"
					+ "values (?,?);");
			ps.setString(1, td.getCodigo());
			ps.setString(2, td.getDescripcion());
			
			ps.executeUpdate();
		} catch (KrakeDevException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new KrakeDevException("Error al insertar tipoDocuemnto. Detalle:"+e.getMessage());
		}
		
	}
	
}
