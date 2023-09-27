package ar.unlam.intraconsulta;

public class Examen {
	private Alumno alumno;
	private Nota nota;
	private TipoDeNota tipoNota;
	
	public Examen(Alumno alum, Nota nota, TipoDeNota tipoNota) {
		
		this.alumno = alum;
		this.nota = nota;
		this.tipoNota = tipoNota;
		
	}
	
	
	
	public Alumno getAlumno() {
		return alumno;
	}
	
	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public Nota getNota() {
		return nota;
	}

	public void setNota(Nota nota) {
		this.nota = nota;
	}

	public TipoDeNota getTipoNota() {
		return tipoNota;
	}

	public void setTipoNota(TipoDeNota tipoNota) {
		this.tipoNota = tipoNota;
	}
}
