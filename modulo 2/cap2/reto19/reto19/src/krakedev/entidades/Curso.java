package krakedev.entidades;

import java.util.ArrayList;

public class Curso {
private ArrayList<Estudiante> estudiantes;



public Curso() {
	
	
}
public Curso(ArrayList<Estudiante> estudiantes) {
	
	this.estudiantes = estudiantes;
}

public ArrayList<Estudiante> getEstudiantes() {
	return estudiantes;
}

public void setEstudiantes(ArrayList<Estudiante> estudiantes) {
	this.estudiantes = estudiantes;
}


public Estudiante buscarEstudiantePorCedula(Estudiante est) {
	
	for (Estudiante estudiante : estudiantes) {
		return estudiante;
	}
	
	return null;
}

public void matricularEstudiante(Estudiante est) {
	
	
	if(buscarEstudiantePorCedula(est)!=null) {
		
		estudiantes.add(est);
	}
	
}

public double calcularPromedioCurso() {
	double suma=0;
	double promedio=0;
	for (Estudiante est : estudiantes) {
		suma+=est.calcularPromedioNotasEstudiante();
	}
	
	promedio=suma/estudiantes.size();
	
	return promedio;
}

public void mostrarInformacion() {
    System.out.println("Curso:");
    System.out.println("Número de estudiantes: " + estudiantes.size());
    System.out.println("Promedio del curso: " + calcularPromedioCurso());

    for (Estudiante estudiante : estudiantes) {
        System.out.println("Estudiante: " + estudiante.getNombre() + " " + estudiante.getApellido());
        System.out.println("Cédula: " + estudiante.getCedula());
        System.out.println("Promedio: " + estudiante.calcularPromedioNotasEstudiante());
        System.out.println("--------------");
    }
}

}
