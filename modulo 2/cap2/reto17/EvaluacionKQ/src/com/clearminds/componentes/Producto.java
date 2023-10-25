package com.clearminds.componentes;


public class Producto {
    private String Nombre;
    private double Precio;
    private String Codigo;



	public Producto( String codigo,String nombre, double precio) {
	
		Nombre = nombre;
		Precio = precio;
		Codigo = codigo;
	}

    public String getNombre() {
		return Nombre;
	}


	public void setNombre(String nombre) {
		Nombre = nombre;
	}


	public String getCodigo() {
		return Codigo;
	}




	public void setCodigo(String codigo) {
		Codigo = codigo;
	}


	public void setPrecio(double precio) {
		Precio = precio;
	}


	public void incrementarPrecio(int porcentaje) {
        double incremento = Precio * porcentaje / 100.0;
        Precio += incremento;
    }


    public void disminuirPrecio(double descuento) {
        Precio -= descuento;
    }

    public double getPrecio() {
        return Precio;
    }
}
