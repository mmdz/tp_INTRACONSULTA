package ar.unlam.intraconsulta;

import java.util.ArrayList;

/*Comision: Representa grupos de estudiantes que cursarán
*  una materia en un ciclo lectivo específico. Tiene asignados 
*  profesores, alumnos, y registros de exámenes.*/

public class Comision {

	private ArrayList<Alumno> alumnoComision = new ArrayList<>();
	private ArrayList<Profesor> profesorComision = new ArrayList<>();
	private Turno turno;
	private Integer dia; /*dias de la semana 1 al 7*/
	private Materia materia;
	private CicloLectivo ciclo; //fecha de inicio
	private Aula nroAula;
	//array de notas por comision
	private ArrayList<Nota> notas = new ArrayList<>();
	
	
	 
	
//getter y setter
	public ArrayList<Alumno> getAlumnoComision() {
		return alumnoComision;
	}

	public void setAlumnoComision(ArrayList<Alumno> alumnoComision) {
		this.alumnoComision = alumnoComision;
	}

	public ArrayList<Profesor> getProfesorComision() {
		return profesorComision;
	}

	public void setProfesorComision(ArrayList<Profesor> profesorComision) {
		this.profesorComision = profesorComision;
	}

	public Turno getTurno() {
		return turno;
	}

	public void setTurno(Turno turno) {
		this.turno = turno;
	}

	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}

	public CicloLectivo getCuatrimestre() {
		return ciclo;
	}

	public void setCuatrimestre(CicloLectivo cuatrimestre) {
		this.ciclo = cuatrimestre;
	}

	public ArrayList<Nota> getNotas() {
		return notas;
	}

	public void setNotas(ArrayList<Nota> notas) {
		this.notas = notas;
	}

	public Aula getNroAula() {
		return nroAula;
	}

	public void setNroAula(Aula nroAula) {
		this.nroAula = nroAula;
	}
	
	public void setDia(Integer dia) {
		this.dia = dia;
	}
	
	public Integer getDia() {
		return dia;
	}
}
