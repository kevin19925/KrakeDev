		package com.krakedev;

public class Calculadora {
	
	 public double multiplicar(double valor1, double valor2) {
	        double producto = valor1 * valor2;
	        return producto;
	    }
	 
	    // Función para calcular el cociente de una división
	    public double dividir(double dividendo, double divisor) {
	        if (divisor != 0) {
	            double cociente = dividendo / divisor;
	            return cociente;
	        } else {
	            System.out.println("Error: Divisor no puede ser cero.");
	            return Double.NaN; // Devolver NaN (Not-a-Number) en caso de división por cero
	        }
	    }

	    // Función para calcular el promedio de tres números
	    public double promediar(double valor1, double valor2, double valor3) {
	        double suma = valor1 + valor2 + valor3;
	        double promedio = suma / 3;
	        return promedio;
	    }
	    // Función para mostrar un mensaje
	    public void mostrarResultado() {
	        System.out.println("Ahorita no joven, Sali al almuerzo. Regreso en 15 minutos");
	    }
}
