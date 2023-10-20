package com.cmc.repaso.entidades;

public class Item {
	  private String nombre;
	    private int productosActuales;
	    private int productosDevueltos;
	    private int productosVendidos;

	    public Item(String nombre) {
	        this.nombre = nombre;
	    }

	    public void imprimir() {
	        System.out.println("Nombre del producto: " + nombre);
	        System.out.println("Productos Actuales: " + productosActuales);
	        System.out.println("Productos Vendidos: " + productosVendidos);
	        System.out.println("Productos Devueltos: " + productosDevueltos);
	    }

	    public void vender(int cantidad) {
	        if (cantidad <= productosActuales) {
	            productosVendidos += cantidad;
	            productosActuales -= cantidad;
	        } else {
	            System.out.println("No hay suficientes productos para vender.");
	        }
	    }

	    public void devolver(int cantidad) {
	        if (cantidad <= productosVendidos) {
	            productosDevueltos += cantidad;
	            productosVendidos -= cantidad;
	            productosActuales += cantidad;
	        } else {
	            System.out.println("No se pueden devolver más productos de los vendidos.");
	        }
	    }

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public int getProductosActuales() {
			return productosActuales;
		}

		public void setProductosActuales(int productosActuales) {
			this.productosActuales = productosActuales;
		}

		public int getProductosDevueltos() {
			return productosDevueltos;
		}

		public void setProductosDevueltos(int productosDevueltos) {
			this.productosDevueltos = productosDevueltos;
		}

		public int getProductosVendidos() {
			return productosVendidos;
		}

		public void setProductosVendidos(int productosVendidos) {
			this.productosVendidos = productosVendidos;
		}
	    
	    
	    
}
