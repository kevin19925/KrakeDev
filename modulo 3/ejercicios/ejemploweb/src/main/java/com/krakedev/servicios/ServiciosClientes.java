package com.krakedev.servicios;

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

import com.krakedev.entidades.Cliente;
import com.krakedev.exepciones.KrakeDevExeption;
import com.krakedev.persistencia.ClientesBDD;
@Path("customers")

public class ServiciosClientes {

	
	@Path("m1")
	@GET
	// accion get con el path de rsw/clientes/metodo1
	// es un servicio , pero es un metodo
	// se consume atrves de http
	public String saludar() {

		return "hola mundo rest web services";
	}

	
	
	
	
	@Path("buscar")
	@GET
	@Produces(MediaType.APPLICATION_JSON) /// FOMRATO CONEL QUE VA RETORNAR

	public Cliente buscar() {

		Cliente c = new Cliente("14556", "kevin");
		return c;
	}
	
	
	

	@Path("insertar")
	@POST
	@Consumes(MediaType.APPLICATION_JSON) // con este formato va a recibir
	public Response insertar (Cliente cliente) {

		System.out.println(">>>>>>>>>>>>>>> insertar " + cliente);
		
		ClientesBDD cli=new ClientesBDD();
		try {
			cli.insertar(cliente);
			return Response.ok().build();
		} catch (KrakeDevExeption e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//armar el eroro para el sevidor 
			return Response.serverError().build();
		}
	}
	
	
	
	

	@Path("act")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON) // con este formato va a recibir
	public void actualizar(Cliente cliente) {

		System.out.println("actualizado>>>>>>>>>>>>>>>" + cliente);
		ClientesBDD cli=new ClientesBDD();
		try {
			cli.actualizar(cliente);
			
		} catch (KrakeDevExeption e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
	}
	
	
	@Path("all")
	@GET
	@Produces(MediaType.APPLICATION_JSON) // con este formato va a recibir
	public Response recuperar() {

		
		ClientesBDD cli=new ClientesBDD();
		ArrayList<Cliente> lista=null;
		try {
			lista= cli.recuperarTodos();
			return Response.ok(lista).build();
			
		} catch (KrakeDevExeption e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Response.serverError().build();
			
		}
		
	}
	
// ejempplo
	// buscarporCedula/14344
	//se llama path param
	@Path("buscarPorCedula/{cedulaParam}")
	@GET
	@Produces(MediaType.APPLICATION_JSON) // con este formato va a recibir
	//cedulaparam revice el parametrode entrada
	public Response buscarPorCedula(@PathParam("cedulaParam") String cedula) {

		
		ClientesBDD cli=new ClientesBDD();
			Cliente cliente=null;
		try {
			cliente= cli.buscarpk(cedula);
			return Response.ok(cliente).build();
			
		} catch (KrakeDevExeption e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Response.serverError().build();
			
		}
		
	}
	
	@Path("allHijos/{num}")
	@GET
	@Produces(MediaType.APPLICATION_JSON) // con este formato va a recibir
	public Response recuperarHijos(@PathParam("num")int num) {

		
		ClientesBDD cli=new ClientesBDD();
		ArrayList<Cliente> lista=null;
		try {
			lista= cli.recuperarHijos(num);
			return Response.ok(lista).build();
			
		} catch (KrakeDevExeption e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Response.serverError().build();
			
		}
		
	}
	
}
