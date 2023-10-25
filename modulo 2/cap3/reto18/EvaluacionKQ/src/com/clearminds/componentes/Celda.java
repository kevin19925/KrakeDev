package com.clearminds.componentes;



public class Celda {
    private Producto producto;
    private int stock;
    private String codigo;


    public Celda(String codigo) {
        this.codigo = codigo;
    }
    public Celda() {
       
    }

    // Método para ingresar un producto con stock inicial
    public void ingresarProducto(Producto producto, int stockInicial) {
        this.producto = producto;
        this.stock = stockInicial;
    }

	public Producto getProducto() {
	
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
    
	  public void incrementarStock(int cantidad) {
	        stock += cantidad;
	    }

	    public void disminuirStock(int cantidad) {
	        if (stock >= cantidad) {
	            stock -= cantidad;
	        } else {
	            System.out.println("No hay suficiente stock en esta celda.");
	        }
	    }

}
