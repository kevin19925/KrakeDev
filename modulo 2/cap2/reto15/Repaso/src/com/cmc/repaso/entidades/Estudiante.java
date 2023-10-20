package com.cmc.repaso.entidades;

public class Estudiante {
	private String nombre;
    private double nota;
    private String resultado;

    public Estudiante(String nombre) {
        this.nombre = nombre;
    }

    public void calificar(double nota) {
        this.nota = nota;
        if (nota < 8) {
            resultado = "F";
        } else {
            resultado = "A";
        }
    }

    public String getNombre() {
        return nombre;
    }

    public double getNota() {
        return nota;
    }

    public String getResultado() {
        return resultado;
    }
}
