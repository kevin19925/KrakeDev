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
import com.krakedev.inventarios.entidades.Categoria_producto;
import com.krakedev.inventarios.entidades.Producto;
import com.krakedev.inventarios.entidades.Proveedor;
import com.krakedev.inventarios.excepciones.KrakeDevExeption;

@Path("categorias")

public class ServiciosCategoria {

	
	@Path("Lista")
	@GET
	@Produces(MediaType.APPLICATION_JSON) // con este formato va a recibir
	public Response recuperar() {

		
		CategoriaBDD cat = new  CategoriaBDD();
		
		ArrayList<Categoria_producto> lista=null;
		try {
			lista= cat.obtenerTodasLasCategorias();
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
	public Response crear(Categoria_producto categoria) {

		System.out.println(">>> objeto de servicios >> " +categoria);
		CategoriaBDD cat = new  CategoriaBDD();
		
		
		try {
			cat.insertar(categoria);
			return Response.ok().build();
			
		} catch (KrakeDevExeption e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Response.serverError().build();
			
		}
		finally {
			System.out.println(">>> objeto de servicios >> " +categoria);
		}
		
	}
	
	@Path("actualizar")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON) // con este formato va a recibir
	public Response actualizar(Categoria_producto categoria) {

		
		
		CategoriaBDD cat = new  CategoriaBDD();
		
		try {
			cat.actualizarCategoria(categoria);
			return Response.ok().build();
			
		} catch (KrakeDevExeption e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Response.serverError().build();
			
		}
		finally {
			System.out.println(">>> objeto de servicios >> " +cat);
		}
		
	}
	
}
