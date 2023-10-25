package krakedev.entidades;

public class Nota {
	private Materia materia;
	
	private Double calificacion;

	
	
	public Nota(Materia materia, Double calificacion) {
		super();
		this.materia = materia;
		this.calificacion = calificacion;
	}
	public Nota() {
	
	}
	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}

	public Double getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(Double calificacion) {
		this.calificacion = calificacion;
	}
	
	
	public void mostrar() {
		
		System.out.println("materia: "+this.materia.getNombre()+" Calificacion : "+this.calificacion);
	}
	

	
	
}
