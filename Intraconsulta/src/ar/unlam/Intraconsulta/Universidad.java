package ar.unlam.intraconsulta;

import java.util.ArrayList;
import java.util.Iterator;

public class Universidad {

	// private Alumno [] alumnos;

	private String nombre; //de la universidad
	private ArrayList<Alumno> alumnos;
	private ArrayList<Materia> materias; //aca guarda el plan de estudio
	private ArrayList<Profesor> profesores;
	private ArrayList<CicloLectivo> cicloLectivo;
	private ArrayList<Comision> comisiones;

	//METODO guardar las inscripciones -> alumno en comision
	
	public Universidad(String nombre) {
		this.nombre = nombre;
		this.alumnos = new ArrayList<>();
		this.materias = new ArrayList<>();
		this.profesores = new ArrayList<>();
		this.cicloLectivo = new ArrayList<>();
		this.comisiones = new ArrayList<>();
		
	}

	public Boolean registrar(Alumno alumno) {

		if (buscarAlumnoPorDni(alumno.getDni()) == null)
		
			return this.alumnos.add(alumno);

		return false;
	}

	public Alumno buscarAlumnoPorDni(Integer dni) {

		for (int i = 0; i < alumnos.size(); i++) {
			if (this.alumnos.get(i).getDni().equals(dni))
				return this.alumnos.get(i);
		}
		
		return null;
	}

	public Boolean existeAlumno(Integer dni) {
		for (int i = 0; i < alumnos.size(); i++) {
			if (this.alumnos.get(i).getDni().equals(dni))
				return true;
		}
		return false;
	}

	public Boolean registraMateria(Materia materia) {
		
		Boolean response = true;
		
		for(Materia elemento: this.materias ) {
			
			if(elemento.getId() == materia.getId()) {
				
				response = false;
				break;
				
			}
			
		}
		
		if(response) {
			this.materias.add(materia);
		}
	   
		return response;
	}

	
	/*
	public boolean inscribirAlumnoAUnaMateria(Integer dni, Integer codigo) {
	
		Alumno alumno = this.buscarAlumnoPorDni(dni);
		Materia materia = this.buscarMateriaPorCodigo(codigo);
		
		if (alumno != null && materia != null) {
			
	    InscripcionMateria  inscripcionMateria = new InscripcionMateria (alumno,materia);
		return this.inscripcionesMateria.add(inscripcionMateria );
			
		}
		
		return false;
	}*/

	/*
	private Materia buscarMateriaPorCodigo(Integer codigo) {
		for (int i = 0; i < this.materias.size(); i++) {
			if (this.materias.get(i).getCodigo().equals(codigo))
				return this.materias.get(i);
		}
		return null;
	}*/
	
	

}
