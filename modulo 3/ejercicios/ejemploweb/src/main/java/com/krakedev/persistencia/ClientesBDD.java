package com.krakedev.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.DefaultRowSorter;

import com.krakedev.entidades.Cliente;
import com.krakedev.exepciones.KrakeDevExeption;
import com.krakedev.utils.ConexionBDD;

public class ClientesBDD {

	public void insertar(Cliente cli) throws KrakeDevExeption {

		Connection con = null;

		try {
			con = ConexionBDD.ontenerConecion();
			PreparedStatement ps = con
					.prepareStatement("insert into clientes (cedula,nombre,numeroHijos) values (?,?,?)");
			ps.setString(1, cli.getCedula());
			ps.setString(2, cli.getNombre());
			ps.setInt(3, 3);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			throw new KrakeDevExeption("error al insertar cliente detalle: "+e.getMessage());
		} catch (KrakeDevExeption e) {
			// si me me ocure un error capturo y relanzo parq ue no se pierda
			// relanzo
			throw e;
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

	}

	public void actualizar(Cliente cli) throws KrakeDevExeption {

		Connection con = null;

		try {
			con = ConexionBDD.ontenerConecion();
			PreparedStatement ps = con
					.prepareStatement("UPDATE clientes SET  nombre=?, numerohijos=? WHERE cedula=? ;");

			ps.setString(1, cli.getNombre());
			ps.setInt(2, cli.getHijos());
			ps.setString(3, cli.getCedula());

			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			throw new KrakeDevExeption("error al actualizar cleinte");
		} catch (KrakeDevExeption e) {
			// si me me ocure un error capturo y relanzo parq ue no se pierda
			// relanzo
			throw e;
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

	}

	public ArrayList<Cliente> recuperarTodos() throws KrakeDevExeption

	{
		ArrayList<Cliente> lista = new ArrayList<Cliente>();
		Connection con = null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Cliente cli=null;
		try {
			con = ConexionBDD.ontenerConecion();
			ps=con.prepareStatement("select * from clientes");
			rs=ps.executeQuery();
			while (rs.next()) {
				
				cli=new Cliente(rs.getString("cedula"), rs.getString("nombre"),rs.getInt("numeroHijos"));
				lista.add(cli);
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

	public Cliente buscarpk(String cedula) throws KrakeDevExeption

	{
	
		Connection con = null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Cliente cli=null;
		try {
			con = ConexionBDD.ontenerConecion();
			ps=con.prepareStatement("select * from clientes where cedula=?");
			ps.setString(1, cedula);
			
			rs=ps.executeQuery();
			if (rs.next()) {
				
				cli=new Cliente(rs.getString("cedula"), rs.getString("nombre"),rs.getInt("numeroHijos"));
				
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
		
		return cli;

	}
	
	
	public ArrayList<Cliente> recuperarHijos(int num) throws KrakeDevExeption

	{
		ArrayList<Cliente> lista = new ArrayList<Cliente>();
		Connection con = null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Cliente cli=null;
		try {
			con = ConexionBDD.ontenerConecion();
			ps=con.prepareStatement("select * from clientes where numerohijos>=?");
			ps.setInt(1, num);
			rs=ps.executeQuery();
			while (rs.next()) {
				
				cli=new Cliente(rs.getString("cedula"), rs.getString("nombre"),rs.getInt("numeroHijos"));
				lista.add(cli);
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
