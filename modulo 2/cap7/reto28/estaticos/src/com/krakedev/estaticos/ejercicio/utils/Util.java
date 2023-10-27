package com.krakedev.estaticos.ejercicio.utils;

public class Util {
    public static String formatearHora(int numero) {
        // Convierte el número a un String de dos caracteres
        String valor = String.valueOf(numero);

        // Agrega un cero delante si el número es de un solo dígito
        if (valor.length() == 1) {
            valor = "0" + valor;
        }

        return valor;
    }

    public static String formatearDia(int numero) {
        String[] diasSemana = {
            "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"
        };

        if (numero >= 0 && numero < diasSemana.length) {
            return diasSemana[numero];
        } else {
            return "Día no válido";
        }
    }
}
