package com.krakedev.inventarios.bdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.krakedev.inventarios.entidades.*;
import com.krakedev.inventarios.entidades.Proveedor;
import com.krakedev.inventarios.entidades.TipoDocumento;
import com.krakedev.inventarios.excepciones.KrakeDevExeption;
import com.krakedev.inventarios.utils.ConexionBDD;



public class ProductoBDD {
	
	public ArrayList<Producto> buscar(String subcadena) throws KrakeDevExeption

	{
		ArrayList<Producto> lista = new ArrayList<Producto>();
		Connection con = null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Proveedor proveedor=null;
		try {
			con = ConexionBDD.ontenerConecion();
			String cadena = ("Select"
					+ " prod.codigo_producto, "//1
					+ "prod.nombre as nombre_producto,"//2
					+ "ud.codigo as nombre,"//3
					+ "ud.descripcion as descipcion_udm,"//4
					+ " CAST (prod.precio_venta as decimal(6,2)), "//5
					+ "prod.tiene_iva,"//6
					+ " CAST (prod.coste as decimal(6,2)), "//7
					+ " cat.codigo_cat,"//8
					+ " cat.nombre as nombre_categoria, "//9
					+ " prod.stock "//10
					+ " from productos prod,unidades_de_medida ud, categorias cat "
					+ " where prod.udm = ud.codigo "
					+ " and prod.categoria = cat.codigo_cat "
					+ " and upper (prod.nombre) like ?");
			System.out.println("<<<>><<>ps>>>>"+cadena);
			ps=con.prepareStatement(cadena);
			
			ps.setString(1,"%" +subcadena.toUpperCase()+"%");
			rs=ps.executeQuery();
			
			
			while (rs.next()) {
				
				Producto prod = new Producto();
				prod.setCodigo(rs.getInt(1));
				prod.setNombre(rs.getString(2));
				
				UnidadDeMedida udm= new UnidadDeMedida();
				udm.setCodigo(rs.getString(3));
				udm.setDescripcion(rs.getString(4));
				
				prod.setUnidadMedida(udm);
				prod.setPrecioVenta(rs.getBigDecimal(5));
				prod.setTieneIva(rs.getBoolean(6));
				prod.setCoste(rs.getBigDecimal(7));
				
				//
				
				Categoria_producto cat = new Categoria_producto();
				cat.setCodigo(rs.getInt(8));
				cat.setNombre(rs.getString(9));
				
				
				prod.setStock(rs.getInt(10));
				prod.setCategoria(cat);
				System.out.println(">>>>producto>>>>"+prod);
				lista.add(prod);
			}
			
			
		} catch (KrakeDevExeption e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new KrakeDevExeption("Error al consultar producto: " +e.getMessage());
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
	

	public void insertar(Producto producto) throws KrakeDevExeption

	{
	
		Connection con = null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try {
			con = ConexionBDD.ontenerConecion();
			ps=con.prepareStatement("INSERT INTO public.productos"
					+ "	 (nombre, udm, precio_venta, tiene_iva, coste, categoria, stock )"
					+ "	VALUES ( ?, ?, ?, ?, ?, ?, ?);");
			
			ps.setString(1,producto.getNombre());
			ps.setString(2,producto.getUnidadMedida().getCodigo());
			ps.setBigDecimal(3,producto.getPrecioVenta());
			ps.setBoolean(4,producto.isTieneIva());
			ps.setBigDecimal(5,producto.getCoste());
			ps.setInt(6,producto.getCategoria().getCodigo());
			ps.setInt(7,producto.getStock());
			System.out.println(">>>>>>>>>>>>>>>>> cadena >>>>" +ps);
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
