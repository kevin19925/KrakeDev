package com.krakedev;

public class Rectangulo {
	// atributos
private double altura=0;
private double base=0;
//metodo para calcular el perimetro
public double calculaePerimetro()
{
return(2*(this.altura+this.base));	
}
public double getAltura() {
	return altura;
}
public void setAltura(double altura) {
	this.altura = altura;
}
public double getBase() {
	return base;
}
public void setBase(double base) {
	this.base = base;
}


}
