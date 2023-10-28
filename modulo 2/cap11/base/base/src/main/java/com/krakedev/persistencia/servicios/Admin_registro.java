package com.krakedev.persistencia.servicios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.Logger;

import com.krakedev.persistencia.entidades.Empleado;
import com.krakedev.persistencia.entidades.Registro_entrada;
import com.krakedev.persistencia.utils.ConexionBDD;

public class Admin_registro {
	private static final Logger LOGGER = LogManager.getLogger(Admin_registro.class);
	
	// CONTROL + SHIL +O
	// org.apache.logging.log4j.Logger
	
	public static void insertar(Registro_entrada registro) throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		LOGGER.trace("insertar"+registro);
		try {
			con = ConexionBDD.conectar();
			System.out.println("insertar");

			ps = con.prepareStatement("INSERT INTO registro_entrada (codigo_registro, fecha, hora, codigo_empleado) "

					+ " VALUES (?,?,?,?)");

			ps.setInt(1, registro.getCodigo_registro());

			ps.setDate(2, new java.sql.Date(registro.getFecha().getTime()));
			ps.setTime(3, new java.sql.Time(registro.getHora().getTime()));
			ps.setInt(4, registro.getEmpleado().getCodigo_empleado());
			ps.executeUpdate();

//	

		} catch (Exception e) {
			// mostrra eroro al usuario
			//System.out.println(e.getMessage()); //prohibido 
			
			// logguear el error 
			//e.printStackTrace();
			LOGGER.error("error al insertar"+e);
			throw new Exception("ERROR AL INSERTAR") ;
			
		} finally {
			
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				LOGGER.error("eroro en la base de datos");
				throw new Exception("error en la base de datos");
			}
		}

	}
	
	
	public static void actualizar(Registro_entrada registro) throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		LOGGER.trace("actualizar"+registro);
		try {
			con = ConexionBDD.conectar();
			System.out.println("actualizar");

			ps = con.prepareStatement("UPDATE registro_entrada"
					+ "	SET  fecha=?, hora=?, codigo_empleado=? where codigo_registro=?");

			

			ps.setDate(1, new java.sql.Date(registro.getFecha().getTime()));
			ps.setTime(2, new java.sql.Time(registro.getHora().getTime()));
			ps.setInt(3, registro.getEmpleado().getCodigo_empleado());
			ps.setInt(4, registro.getCodigo_registro());
			ps.executeUpdate();

//	

		} catch (Exception e) {
			// mostrra eroro al usuario
			//System.out.println(e.getMessage()); //prohibido 
			
			// logguear el error 
			//e.printStackTrace();
			LOGGER.error("error al  editar"+e);
			throw new Exception("ERROR AL editar") ;
			
		} finally {
			
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				LOGGER.error("eroro en la base de datos");
				throw new Exception("error en la base de datos");
			}
		}

	}
	
	
	public static void eliminar(Registro_entrada registro) throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		LOGGER.trace("actualizar"+registro);
		try {
			con = ConexionBDD.conectar();
			System.out.println("eliminar");

			ps = con.prepareStatement("DELETE FROM registro_entrada"
					+ "	WHERE codigo_registro=?");

			

			
			ps.setInt(1, registro.getCodigo_registro());
			ps.executeUpdate();

//	

		} catch (Exception e) {
			// mostrra eroro al usuario
			//System.out.println(e.getMessage()); //prohibido 
			
			// logguear el error 
			//e.printStackTrace();
			LOGGER.error("error al  eliminar"+e);
			throw new Exception("ERROR AL editar") ;
			
		} finally {
			
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				LOGGER.error("eroro en la base de datos");
				throw new Exception("error en la base de datos");
			}
		}
		
	}
	
	
	
	

	public static Empleado buscarcodigo(int codigo_empleado) throws Exception {
		Empleado empleadoencontrado = new Empleado();
		Connection con = null;
		PreparedStatement ps;
		ResultSet rs = null;
		try {
			con = ConexionBDD.conectar();
			System.out.println("buqueda pk");

			ps = con.prepareStatement("SELECT * FROM empleados "
					+ "	WHERE codigo_empleado =?");
			
			ps.setInt(1, codigo_empleado);
			rs = ps.executeQuery();

			if (rs.next()) {
				int codigo =rs.getInt("codigo_empleado");
				String nombre1 = rs.getString("nombre");
				
				
				Empleado u = new Empleado();
				u.setCodigo_empleado(codigo);
				u.setNombre(nombre1);
				
				empleadoencontrado=u;
			}

		} catch (Exception e) {
			LOGGER.error("Error al consultar por cedula pk ", e);
			throw new Exception("Error al consultar por cedula pk u");

		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				LOGGER.error("Error con la base de datos", e);
				throw new Exception("Error con la base");
			}
		}

		return empleadoencontrado;
	}

	
	public static ArrayList<Empleado> buscarNombres(String nombre) throws Exception {
		ArrayList<Empleado> empleados = new ArrayList<Empleado>();
		Empleado empleadoencontrado = new Empleado();
		Connection con = null;
		PreparedStatement ps;
		ResultSet rs = null;
		try {
			con = ConexionBDD.conectar();
			System.out.println("buscra una lista ");

			ps = con.prepareStatement("select * from empleados where nombre like ?");
			ps.setString(1, '%' + nombre + '%');

			rs = ps.executeQuery();

			while (rs.next()) {
				int codigo =rs.getInt("codigo_empleado");
				String nombre1 = rs.getString("nombre");
				
				
				Empleado u = new Empleado();
				u.setCodigo_empleado(codigo);
				u.setNombre(nombre1);
				
				empleados.add(u);
			}

		} catch (Exception e) {
			LOGGER.error("Error al consultar por apellido de usuario", e);
			throw new Exception("Error al consultar por apellido de usuario");
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				LOGGER.error("Error con la base de datos", e);
				throw new Exception("Error con la base de datos");
			}
		}

		return empleados;
	}
	
	
}
