package com.krakedev.inventarios.bdd;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import com.krakedev.inventarios.entidades.DetallePedido;
import com.krakedev.inventarios.entidades.DetalleVenta;
import com.krakedev.inventarios.entidades.Pedido;
import com.krakedev.inventarios.entidades.Venta;
import com.krakedev.inventarios.excepciones.KrakeDevExeption;
import com.krakedev.inventarios.utils.ConexionBDD;

public class VentasBDD {

	public void insertar(Venta venta) throws KrakeDevExeption

	{

		Connection con = null;
		PreparedStatement ps = null;
		PreparedStatement psDetalle = null;
		ResultSet rs = null;
		ResultSet claveGenerada = null;
		int codigo = 0;
		Date fechaActual = new Date();

		java.sql.Timestamp fechaSQL = new java.sql.Timestamp(fechaActual.getTime());

		try {
			
			
			// inserto la cabecera de ventas solo con la fecha lo demas 0
			con = ConexionBDD.ontenerConecion();
			ps = con.prepareStatement("INSERT INTO public.cabecera_ventas ( "
					+ "	  fecha, total_sin_iva, iva, total) " + "	VALUES ( ?, ?, ?,?);",
					Statement.RETURN_GENERATED_KEYS);

			ps.setTimestamp(1, fechaSQL);
			ps.setBigDecimal(2, BigDecimal.ZERO);
			ps.setBigDecimal(3, BigDecimal.ZERO);
			ps.setBigDecimal(4, BigDecimal.ZERO);
			System.out.println(">>>> 1) " + ps);
			ps.executeUpdate();
			claveGenerada = ps.getGeneratedKeys();
			if (claveGenerada.next()) {
				codigo = claveGenerada.getInt(1);

			}

			System.out.println("codigo cabecera ventas>>>" + codigo);
			BigDecimal sumaSubtotal_con_iva = new BigDecimal(0);
			BigDecimal sumaSubtotal_sin_iva = new BigDecimal(0);;

			// for para andir todos lo sdetalles de ventas 
			for (DetalleVenta ventDet : venta.getDetalles()) {
				psDetalle = con.prepareStatement("INSERT INTO public.detalle_ventas ( "
						+ "	 cabecera_venta, producto, cantidad, precio_venta, subtotal,total_con_iva) "
						+ "	VALUES ( ?, ?, ?, ?, ?,?);");
				psDetalle.setInt(1, codigo);
				psDetalle.setInt(2, ventDet.getProducto().getCodigo());
				psDetalle.setInt(3, ventDet.getCantidad());
				psDetalle.setBigDecimal(4, ventDet.getProducto().getPrecioVenta());
				BigDecimal subtotal = ventDet.getProducto().getPrecioVenta()
						.multiply(new BigDecimal(ventDet.getCantidad()));
				psDetalle.setBigDecimal(5, subtotal);
				BigDecimal subtotal_con_iva = new BigDecimal(0);;

				if (ventDet.getProducto().isTieneIva()) {
					subtotal_con_iva = subtotal.multiply(new BigDecimal(1.12));
					sumaSubtotal_con_iva = sumaSubtotal_con_iva.add(subtotal_con_iva);
				} else {
					subtotal_con_iva = subtotal;
					sumaSubtotal_sin_iva = sumaSubtotal_sin_iva.add(subtotal_con_iva);
				}
				psDetalle.setBigDecimal(6, subtotal_con_iva);
				System.out.println(">>>> 2--) " + psDetalle);
				psDetalle.execute();
			}

			
			// se actualiza las cabeceras con datos  con iva y sin iva
			ps = con.prepareStatement("UPDATE public.cabecera_ventas " + "	SET  total_sin_iva=?, iva=?, total=? "
					+ "	WHERE codigo =?;");

			ps.setBigDecimal(1, sumaSubtotal_sin_iva);
			ps.setBigDecimal(2, sumaSubtotal_con_iva);
			ps.setBigDecimal(3, sumaSubtotal_sin_iva.add(sumaSubtotal_con_iva));
			ps.setInt(4, codigo);
			System.out.println(">>>> 3) " + ps);
			ps.execute();

			// anadimos al historial 
			for (DetalleVenta ventDet : venta.getDetalles()) {
				psDetalle = con.prepareStatement("INSERT INTO public.historial_stock ( "
						+ "	fecha, referencia, producto, cantidad )" + "	VALUES (?, ?, ?, ?);");
				psDetalle.setTimestamp(1, fechaSQL);
				psDetalle.setString(2, "VENTA " + codigo);
				psDetalle.setInt(3, ventDet.getProducto().getCodigo());
				psDetalle.setInt(4, -1*ventDet.getCantidad());
				System.out.println(">>>> 4)--  " + psDetalle);
				psDetalle.execute();
			}

		} catch (KrakeDevExeption e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new KrakeDevExeption("Error en el proceso de ventas " + e.getMessage());
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
	/*
	 * public void actualizar(Pedido pedido) throws KrakeDevExeption
	 * 
	 * {
	 * 
	 * Connection con = null; PreparedStatement ps=null; PreparedStatement
	 * psDetalle=null; ResultSet rs=null; ResultSet claveGenerada =null; int
	 * codigo=0 ; Date fechaActual = new Date();
	 * 
	 * 
	 * java.sql.Date fechaSQL = new java.sql.Date(fechaActual.getTime());
	 * java.sql.Timestamp fechaHoraSQl = new
	 * java.sql.Timestamp(fechaActual.getTime());
	 * 
	 * try { con = ConexionBDD.ontenerConecion(); ps=con.
	 * prepareStatement("UPDATE cabecera_pedido SET  estado = ? WHERE numero = ? ");
	 * 
	 * 
	 * ps.setString(1, "R"); ps.setInt(2,pedido.getCodigo());
	 * 
	 * 
	 * System.out.println("codigoo cabecera>>>"+pedido.getCodigo()); ps.execute();
	 * 
	 * for (DetallePedido det : pedido.getDetalles()) {
	 * psDetalle=con.prepareStatement("UPDATE  detalle_pedido set " +
	 * "	 cantidad_recibida = ? where codigo = ?  ");
	 * 
	 * psDetalle.setInt(1, det.getCantidadRecibida()); psDetalle.setInt(2,
	 * det.getCodigo());
	 * 
	 * 
	 * psDetalle.execute();
	 * 
	 * psDetalle=con.prepareStatement("INSERT INTO public.historial_stock( " +
	 * "	fecha, referencia, producto, cantidad)" + "	VALUES (?, ?, ?, ?);");
	 * 
	 * psDetalle.setTimestamp(1, fechaHoraSQl); psDetalle.setString(2,
	 * "PEDIDO "+pedido.getCodigo()); psDetalle.setInt(3,
	 * det.getProducto().getCodigo()); psDetalle.setInt(4,
	 * det.getCantidadRecibida());
	 * 
	 * psDetalle.execute();
	 * 
	 * 
	 * }
	 * 
	 * 
	 * } catch (KrakeDevExeption e) { e.printStackTrace(); throw e; } catch
	 * (SQLException e) { // TODO Auto-generated catch block e.printStackTrace();
	 * throw new KrakeDevExeption("Error al actulizar pedido " +e.getMessage()); }
	 * finally { if (con != null) { try { con.close(); } catch (SQLException e) { //
	 * TODO Auto-generated catch block e.printStackTrace(); } }
	 * System.out.println("actualizar pedido >>>>>>"+ps); }
	 * 
	 * 
	 * }
	 */

}
