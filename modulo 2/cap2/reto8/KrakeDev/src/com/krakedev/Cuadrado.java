package com.krakedev;

public class Cuadrado {
	 private double lado;
	 
	 public double calcularArea() {
		return Math.pow(lado,2);
	}
	
	public double getLado() {
		return lado;
	}

	public void setLado(double lado) {
		this.lado = lado;
	}

	public double calculaePerimetro()
	{
	return(4*(this.lado));	
	}
}
