package com.krakedev.inventarios.servicios;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.krakedev.inventarios.bdd.*;
import com.krakedev.inventarios.entidades.*;
import com.krakedev.inventarios.excepciones.KrakeDevExeption;

@Path("tiposdocumentos")

public class ServiciosDocumentos {

	
	@Path("recuperar")
	@GET
	@Produces(MediaType.APPLICATION_JSON) // con este formato va a recibir
	public Response recuperar() {

		
		 DocumentosBDD doc=new DocumentosBDD();
		ArrayList<Documento> lista=null;
		try {
			lista= doc.tipo_documentos();
			return Response.ok(lista).build();
			
		} catch (KrakeDevExeption e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Response.serverError().build();
			
		}
		
	}
	
}
