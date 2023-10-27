package krakedev.entidades;

import java.util.ArrayList;

public class Estudiante {
private String  nombre;
private String apellido;
private String cedula;
private ArrayList<Nota> notas;



public Estudiante(String nombre, String apellido, String cedula, ArrayList<Nota> notas) {
	super();
	this.nombre = nombre;
	this.apellido = apellido;
	this.cedula = cedula;
	this.notas = notas;
}


public Estudiante() {
	
}


public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public String getApellido() {
	return apellido;
}
public void setApellido(String apellido) {
	this.apellido = apellido;
}
public String getCedula() {
	return cedula;
}
public void setCedula(String cedula) {
	this.cedula = cedula;
}
public ArrayList<Nota> getNotas() {
	return notas;
}
public void setNotas(ArrayList<Nota> notas) {
	this.notas = notas;
}

public void agregarNota(Nota newnota) {
	
	for (Nota nota : notas) {
		if(!nota.getMateria().getCodigo().equals(newnota.getMateria().getCodigo())) {
			this.notas.add(newnota);
		}
	}
}

public void modificarNota(String Codigo ,double newnota) {
	boolean encontrada=false;
	for (Nota nota : notas) {
		if(nota.getMateria().getCodigo().equals(Codigo)&& newnota>=0 && newnota<=10) {
			
			nota.setCalificacion(newnota);
			encontrada=true;
		}

	}
	
	if (encontrada==false) {
		System.err.println("No se encontro codigo");
	}
	
	
}

public double calcularPromedioNotasEstudiante() {
	double suma=0;
	double promedio=0;
	for (Nota nota : notas) {
		suma+=nota.getCalificacion();
	}
	
	promedio=suma/notas.size();
	
	return promedio;
}

public void mostrar() {
	
	 System.out.println("Nombre: " + nombre);
     System.out.println("Apellido: " + apellido);
     System.out.println("Cédula: " + cedula);
     
     System.out.println("Notas:");
     for (Nota nota : notas) {
         System.out.println("Materia: " + nota.getMateria());
         System.out.println("Calificación: " + nota.getCalificacion());
         System.out.println("---------------");
     }
}

}

