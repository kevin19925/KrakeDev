package com.krakedev.inventarios.bdd;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import com.krakedev.inventarios.entidades.DetallePedido;
import com.krakedev.inventarios.entidades.Pedido;
import com.krakedev.inventarios.excepciones.KrakeDevExeption;
import com.krakedev.inventarios.utils.ConexionBDD;


public class PedidosBDD {
	
	
	public void insertar(Pedido pedido) throws KrakeDevExeption

	{
	
		Connection con = null;
		PreparedStatement ps=null;
		PreparedStatement psDetalle=null;
		ResultSet rs=null;
		ResultSet claveGenerada =null;
		int codigo=0 ;
		Date fechaActual = new Date();

        
        java.sql.Date fechaSQL = new java.sql.Date(fechaActual.getTime());
        
		try { 
			con = ConexionBDD.ontenerConecion();
			ps=con.prepareStatement("INSERT INTO public.cabecera_pedido ( "
					+ "	 proveedor, fecha, estado) "
					+ "	VALUES ( ?, ?, ?);",Statement.RETURN_GENERATED_KEYS );

			
			ps.setString(1,pedido.getProveedor().getIdentificador());
			ps.setDate(2, fechaSQL);
			ps.setString(3, "S");
			ps.executeUpdate();
			claveGenerada=ps.getGeneratedKeys();
			if(claveGenerada.next()) {
				codigo= claveGenerada.getInt(1);
				
			}
			
			System.out.println("cogiho cabecera>>>"+codigo);
			
			
			for (DetallePedido det : pedido.getDetalles()) {
				psDetalle=con.prepareStatement("INSERT INTO public.detalle_pedido ("
						+ "	 cabecera_pedido, producto, cantidad_solicitada, cantidad_recibida, subtotal) "
						+ "	VALUES ( ?, ?, ?, ?, ?);" );
				psDetalle.setInt(1, codigo);
				psDetalle.setInt(2, det.getProducto().getCodigo());
				psDetalle.setInt(3, det.getCantidadSolicitada());
				psDetalle.setInt(4, 0);
				psDetalle.setBigDecimal(5, det.getProducto().getPrecioVenta().multiply(new BigDecimal(det.getCantidadSolicitada())));
			psDetalle.execute();
			}
			
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
	
	public void actualizar(Pedido pedido) throws KrakeDevExeption

	{
	
		Connection con = null;
		PreparedStatement ps=null;
		PreparedStatement psDetalle=null;
		ResultSet rs=null;
		ResultSet claveGenerada =null;
		int codigo=0 ;
		Date fechaActual = new Date();

        
        java.sql.Date fechaSQL = new java.sql.Date(fechaActual.getTime());
        java.sql.Timestamp fechaHoraSQl = new    java.sql.Timestamp(fechaActual.getTime());
        
		try { 
			con = ConexionBDD.ontenerConecion();
			ps=con.prepareStatement("UPDATE cabecera_pedido SET  estado = ? WHERE numero = ? ");
				

			ps.setString(1, "R");
			ps.setInt(2,pedido.getCodigo());
			
			
			System.out.println("codigoo cabecera>>>"+pedido.getCodigo());
			ps.execute();
			
			for (DetallePedido det : pedido.getDetalles()) {
				psDetalle=con.prepareStatement("UPDATE  detalle_pedido set "
						+ "	 cantidad_recibida = ? where codigo = ?  ");
						
				psDetalle.setInt(1, det.getCantidadRecibida());
				psDetalle.setInt(2, det.getCodigo());
				
				
			psDetalle.execute();
			
			psDetalle=con.prepareStatement("INSERT INTO public.historial_stock( "
					+ "	fecha, referencia, producto, cantidad)"
					+ "	VALUES (?, ?, ?, ?);");
			
			psDetalle.setTimestamp(1, fechaHoraSQl);
			psDetalle.setString(2, "PEDIDO "+pedido.getCodigo());
			psDetalle.setInt(3, det.getProducto().getCodigo());
			psDetalle.setInt(4, det.getCantidadRecibida());
			
		psDetalle.execute();
			
			
			}
			
			
		} catch (KrakeDevExeption e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new KrakeDevExeption("Error al actulizar pedido " +e.getMessage());
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println("actualizar pedido >>>>>>"+ps);
		}
		
		
	}
	
}
