package com.krakedev.inventarios.bdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.krakedev.inventarios.entidades.Proveedor;
import com.krakedev.inventarios.entidades.TipoDocumento;
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
			ps=con.prepareStatement("select prov.identificador,prov.tipo_documento, td.descripcion,"
					+ " prov.nombre, prov.telefono,prov.correo, prov.direccion from proveedores prov , "
					+ " tipo_documentos td where prov.tipo_documento=td.codigo and upper (nombre) like ?");
			ps.setString(1,"%" +subcadena.toUpperCase()+"%");
			rs=ps.executeQuery();
		
			System.out.println(ps);
			while (rs.next()) {
				TipoDocumento tipoDoc = new TipoDocumento(rs.getString(2), rs.getString(3));
				proveedor=new Proveedor(rs.getString(1), tipoDoc,rs.getString("nombre"),rs.getString("telefono"),rs.getString("correo"),rs.getString("direccion"));
				
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
	
	public ArrayList<Proveedor> buscarId(String subcadena) throws KrakeDevExeption

	{
		ArrayList<Proveedor> lista = new ArrayList<Proveedor>();
		Connection con = null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Proveedor proveedor=null;
		try {
			con = ConexionBDD.ontenerConecion();
			ps=con.prepareStatement("select prov.identificador,prov.tipo_documento, td.descripcion,"
					+ " prov.nombre, prov.telefono,prov.correo, prov.direccion from proveedores prov , "
					+ " tipo_documentos td where prov.tipo_documento=td.codigo and prov.identificador=?");
			ps.setString(1,subcadena);
			rs=ps.executeQuery();
		
			System.out.println(ps);
			while (rs.next()) {
				TipoDocumento tipoDoc = new TipoDocumento(rs.getString(2), rs.getString(3));
				proveedor=new Proveedor(rs.getString(1), tipoDoc,rs.getString("nombre"),rs.getString("telefono"),rs.getString("correo"),rs.getString("direccion"));
				
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

	public void insertar(Proveedor proveedor) throws KrakeDevExeption

	{
	
		Connection con = null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try {
			con = ConexionBDD.ontenerConecion();
			ps=con.prepareStatement("INSERT INTO proveedores("
					+ "	identificador, tipo_documento, nombre, telefono, correo, direccion)"
					+ "	VALUES (?, ?, ?, ?, ?, ?);");
			
			ps.setString(1,proveedor.getIdentificador());
			ps.setString(2,proveedor.getTipoDocumento().getCodigo().toString());
			ps.setString(3,proveedor.getNombre());
			ps.setString(4,proveedor.getTelefono());
			ps.setString(5,proveedor.getCorreo());
			ps.setString(6,proveedor.getDireccion());
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
