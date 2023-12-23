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
import com.krakedev.inventarios.excepciones.KrakeDevExeption;

@Path("pedidos")

public class ServiciosPedidos {

	
	@Path("crear")
	@POST
	@Consumes(MediaType.APPLICATION_JSON) // con este formato va a recibir
	public Response crear(Pedido pedido) {

		
		PedidosBDD p = new PedidosBDD () ;
		
		
		try {
			p.insertar(pedido);
			return Response.ok().build();
			
		} catch (KrakeDevExeption e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Response.serverError().build();
			
		}
		finally {
			System.out.println(">>> objeto de servicios pedido >> " +pedido);
		}
		
	}
	
	@Path("recibir")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON) // con este formato va a recibir
	public Response recibir(Pedido pedido) {

		
		PedidosBDD p = new PedidosBDD () ;
		
		
		try {
			p.actualizar(pedido);
			return Response.ok().build();
			
		} catch (KrakeDevExeption e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Response.serverError().build();
			
		}
		finally {
			System.out.println(">>> objeto de servicios pedido actualizr >> " +pedido);
		}
		
	}
	

	@Path("buscarProveedor/{cadena}")
	@GET
	@Produces(MediaType.APPLICATION_JSON) // con este formato va a recibir
	public Response recuperarPedidos(@PathParam("cadena") String cadena) {

		
		PedidosBDD p = new PedidosBDD () ;
		ArrayList<Pedido> lista=null;
		try {
			lista= p.buscarPedidosPorProveedor(cadena);
			return Response.ok(lista).build();
			
		} catch (KrakeDevExeption e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Response.serverError().build();
			
		}
		
	}
	
  
}
