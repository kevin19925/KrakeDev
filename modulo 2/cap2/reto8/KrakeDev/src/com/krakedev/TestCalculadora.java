package com.krakedev;

public class TestCalculadora {


	    public static void main(String[] args) {
	        // Crear una instancia de la clase Calculadora
	        Calculadora miCalculadora = new Calculadora();

	        // Ejemplo de uso de la función multiplicar
	        double numero1 = 10.0;
	        double numero2 = 5.0;
	        double resultadoMultiplicacion = miCalculadora.multiplicar(numero1, numero2);
	        System.out.println("El resultado de la multiplicación es: " + resultadoMultiplicacion);

	        // Ejemplo de uso de la función dividir
	        double dividendo = 10.0;
	        double divisor = 2.0;
	        double cociente = miCalculadora.dividir(dividendo, divisor);
	        System.out.println("El cociente de " + dividendo + " dividido por " + divisor + " es: " + cociente);

	        // Ejemplo de uso de la función promediar
	        double num1 = 10.0;
	        double num2 = 8.0;
	        double num3 = 9.0;
	        double promedio = miCalculadora.promediar(num1, num2, num3);
	        System.out.println("El promedio de " + num1 + ", " + num2 + " y " + num3 + " es: " + promedio);

	        // Invocar la función mostrarResultado
	        miCalculadora.mostrarResultado();
	    }
	}


