package com.krakedev.inventarios.servicios;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.krakedev.inventarios.bdd.ProveedoresBDD;
import com.krakedev.inventarios.entidades.Proveedor;
import com.krakedev.inventarios.excepciones.KrakeDevExeption;

@Path("proveedores")

public class ServiciosProveedor {

	
	@Path("buscar/{cadena}")
	@GET
	@Produces(MediaType.APPLICATION_JSON) // con este formato va a recibir
	public Response recuperar(@PathParam("cadena") String cadena) {

		
		ProveedoresBDD proveedor =new ProveedoresBDD();
		ArrayList<Proveedor> lista=null;
		try {
			lista= proveedor.buscar(cadena);
			return Response.ok(lista).build();
			
		} catch (KrakeDevExeption e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Response.serverError().build();
			
		}
		
	}
	@Path("buscarId/{cadena}")
	@GET
	@Produces(MediaType.APPLICATION_JSON) // con este formato va a recibir
	public Response recuperarId(@PathParam("cadena") String cadena) {

		
		ProveedoresBDD proveedor =new ProveedoresBDD();
		ArrayList<Proveedor> lista=null;
		try {
			lista= proveedor.buscarId(cadena);
			return Response.ok(lista).build();
			
		} catch (KrakeDevExeption e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Response.serverError().build();
			
		}
		
	}
	
	@Path("crear")
	@POST
	@Consumes(MediaType.APPLICATION_JSON) // con este formato va a recibir
	public Response crear(Proveedor pro) {

		
		ProveedoresBDD proveedor =new ProveedoresBDD();
		
		
		try {
			proveedor.insertar(pro);
			return Response.ok().build();
			
		} catch (KrakeDevExeption e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Response.serverError().build();
			
		}
		finally {
			System.out.println(">>> servicos " +pro);
		}
		
	}
	
}
