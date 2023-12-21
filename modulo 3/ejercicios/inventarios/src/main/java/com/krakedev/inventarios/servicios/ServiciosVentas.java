package com.krakedev.inventarios.servicios;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.krakedev.inventarios.bdd.*;
import com.krakedev.inventarios.entidades.Pedido;
import com.krakedev.inventarios.entidades.Producto;
import com.krakedev.inventarios.entidades.Proveedor;
import com.krakedev.inventarios.entidades.Venta;
import com.krakedev.inventarios.excepciones.KrakeDevExeption;

@Path("ventas")

public class ServiciosVentas {

	
	
	
	@Path("guardar")
	@POST
	@Consumes(MediaType.APPLICATION_JSON) // con este formato va a recibir
	public Response crear(Venta venta) {

		
		VentasBDD ventas = new VentasBDD()  ;
		
		
		try {
			ventas.insertar(venta);
			return Response.ok().build();
			
		} catch (KrakeDevExeption e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Response.serverError().build();
			
		}
		finally {
			System.out.println(">>> objeto de venta >> " +venta);
		}
		
	}
}
	