package com.krakedev.inventario.servicios;
import java.util.ArrayList;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.krakedev.inventario.entidades.Categoria;
import com.krakedev.inventario.entidades.Producto;
@Path("productos")
public class ServiciosProducto {
	@Path("insertar")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void insertar(Producto p) {
		System.out.println("insertar>>>" + p);
	}
	
	
	@Path("actualizar")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	
	public void actualizar(Producto p) {
		System.out.println("actualizar>>>" + p);
	}

	
	@Path ("consultar")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Producto> recuperarTodos() {
		Categoria cat = new Categoria(1, "dulces");
		ArrayList<Producto> lista = new ArrayList<Producto>();
		lista.add(new Producto("1", "n1", cat, 1, 1));
		lista.add(new Producto("2", "n2", cat, 2, 2));
		lista.add(new Producto("3", "n3", cat, 3, 3));
		return lista;
	}

}
