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



public class CategoriaBDD {
	
	public ArrayList<Categoria_producto> obtenerTodasLasCategorias() throws KrakeDevExeption {
        ArrayList<Categoria_producto> listaCategorias = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = ConexionBDD.ontenerConecion();
            String cadena = "SELECT codigo_cat, nombre, categoria_padre FROM public.categorias";
            ps = con.prepareStatement(cadena);
            rs = ps.executeQuery();
System.out.println(cadena);
            while (rs.next()) {
                Categoria_producto categoria = new Categoria_producto();
                categoria.setCodigo(rs.getInt("codigo_cat"));
                categoria.setNombre(rs.getString("nombre"));
                categoria.setCodigo_padre(rs.getInt("categoria_padre"));

                listaCategorias.add(categoria);
            }

        } catch (KrakeDevExeption | SQLException e) {
            e.printStackTrace();
            throw new KrakeDevExeption("Error al obtener todas las categorías: " + e.getMessage());
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return listaCategorias;
    }

	public void insertar(Categoria_producto cat) throws KrakeDevExeption

	{
	
		Connection con = null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try {
			con = ConexionBDD.ontenerConecion();
			 
	            ps = con.prepareStatement("INSERT INTO public.categorias (nombre, categoria_padre) VALUES (?, ?)");

	            ps.setString(1, cat.getNombre());
	            Integer valor = cat.getCodigo_padre(); // Esto podría ser un valor entero o null
System.out.println(">>>>>>>>>>>>>> --"+ cat);
	            if (valor != 0) {
					ps.setInt(2, valor);}
	            if (valor ==0) {
					ps.setNull(2, java.sql.Types.INTEGER);
	            }
	            
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
	
	
	 public void actualizarCategoria(Categoria_producto cat) throws KrakeDevExeption {
	        Connection con = null;
	        PreparedStatement ps = null;

	        try {
	            con = ConexionBDD.ontenerConecion();
	            ps = con.prepareStatement("UPDATE public.categorias SET nombre = ?, categoria_padre = ? WHERE codigo_cat = ?");

	            ps.setString(1, cat.getNombre());
	            ps.setInt(2, cat.getCodigo_padre());
	            ps.setInt(3, cat.getCodigo());
	            
	            System.out.println(">>>>>>>>>>>>>>>>> cadena >>>>" + ps);
	            ps.executeUpdate();

	        } catch (KrakeDevExeption e) {
	            e.printStackTrace();
	            throw e;
	        } catch (SQLException e) {
	            e.printStackTrace();
	            throw new KrakeDevExeption("Error al actualizar categoría: " + e.getMessage());
	        } finally {
	            if (con != null) {
	                try {
	                    con.close();
	                } catch (SQLException e) {
	                    e.printStackTrace();
	                }
	            }
	            
	        }
	    }
}
