package ar.unlam.intraconsulta;

import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

public class Universidad {


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

	//alumno
	public Boolean registrarAlumno(Alumno alumno) {
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
	
	public Boolean borrarAlumno(Alumno alumno) {		
			if (existeProfesor(alumno.getDni()) != null)		
				return this.alumnos.remove(alumno);
			return false;
	}
	
	
//profesor	
	public Boolean registrarProfesor(Profesor profesor) {
		if (buscarProfesorPorDni(profesor.getDni()) == null)		
			return this.profesores.add(profesor);
		return false;
	}

	public Profesor buscarProfesorPorDni(Integer dni) {
		for (int i = 0; i < profesores.size(); i++) {
			if (this.profesores.get(i).getDni().equals(dni))
				return this.profesores.get(i);
		}	
		return null;
	}

	public Boolean existeProfesor(Integer dni) {
		for (int i = 0; i < profesores.size(); i++) {
			if (this.profesores.get(i).getDni().equals(dni))
				return true;			
		}
		return false;
	}
	
	public Boolean borrarProfesor(Profesor profesor) {
		if (existeProfesor(profesor.getDni()) != null)		
			return this.profesores.remove(profesor);
		return false;
	}

//cicloLectivo
	public Boolean agregarCicloLectivo(CicloLectivo ciclo) {
		if (buscarCicloLectivoPorId(ciclo.getId()) == null)		
			return this.cicloLectivo.add(ciclo);
		return false;
	}
	
	public CicloLectivo buscarCicloLectivoPorId(Integer id) {
		for (int i = 0; i < cicloLectivo.size(); i++) {
			if (this.cicloLectivo.get(i).getId().equals(id))
				return this.cicloLectivo.get(i);
		}	
		return null;
	}
	
	
	public Boolean validarRangoFecha(CicloLectivo ciclo) {
		/*1ro valido q los rangos sean correctos (enero antes q marzo)*/
		Boolean rangoInscripcion_1 = ciclo.fechaDeInicioDeInscripcion.isBefore(ciclo.fechaDeCierreDeInscripcion);		
		Boolean rangoCursada_1 = ciclo.fechaDeInicioDeCuatrimestre.isBefore(ciclo.fechaDeFinDeCuatrimestre);
		
		if(rangoInscripcion_1 == true &&  rangoCursada_1 == true) {
			if(ciclo.fechaDeCierreDeInscripcion.isBefore(ciclo.fechaDeInicioDeCuatrimestre)) {
				return true;
			}
		}
		return false;
	}	

	public Boolean compararFechasDeCiclos(CicloLectivo ciclo_1, CicloLectivo ciclo_2) {
		Boolean RangoCiclo_1 = validarRangoFecha(ciclo_1);
		Boolean RangoCiclo_2 = validarRangoFecha(ciclo_2);

		if(RangoCiclo_1 == true && RangoCiclo_2 == true) {
			/*fin de 1C antes de inscr de 2C (jul antes agos)*/
			if(ciclo_1.fechaDeFinDeCuatrimestre.isBefore(ciclo_2.fechaDeInicioDeInscripcion)) {
				return true;
			}	
		}
		return false;
	}


	
//materia
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

	public boolean agregarCorrelatividad(Integer id, Integer id2) {
		
		Boolean returnValue = false;
		
		Materia materia = this.buscarMateriaById(id);
		Materia correlativa = this.buscarMateriaById(id2);
		
		if(materia != null && correlativa != null) {
			
			materia.agregarCorrelativa(correlativa.getId());
			returnValue = true;
		}
		
		return returnValue;
	}

	
	private Materia buscarMateriaById(Integer id) {
		
		Materia value = null;
		
		for(Materia materia: this.materias) {
			if(materia.getId() == id) {
				value = materia;
				break;
			}
		}
		
		return value;
		
	}

	public boolean eliminarCorrelatividad(Integer id, Integer id2) {
		
		Boolean returnValue = false;
		
		Materia materia = this.buscarMateriaById(id);
		Materia correlativa = this.buscarMateriaById(id2);
		
		if(materia != null && correlativa != null) {
			
			
			if(materia.getCorrelativa().contains(correlativa.getId())) {
				
				materia.getCorrelativa().remove(correlativa.getId());
				returnValue = true;
				
			}
			
			//materia.agregarCorrelativa(correlativa.getId());
		}
		
		return returnValue;
		
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
	
//getter y setter	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public ArrayList<Alumno> getAlumnos() {
		return alumnos;
	}
	public void setAlumnos(ArrayList<Alumno> alumnos) {
		this.alumnos = alumnos;
	}
	public ArrayList<Materia> getMaterias() {
		return materias;
	}
	public void setMaterias(ArrayList<Materia> materias) {
		this.materias = materias;
	}
	public ArrayList<Profesor> getProfesores() {
		return profesores;
	}
	public void setProfesores(ArrayList<Profesor> profesores) {
		this.profesores = profesores;
	}
	public ArrayList<CicloLectivo> getCicloLectivo() {
		return cicloLectivo;
	}
	public void setCicloLectivo(ArrayList<CicloLectivo> cicloLectivo) {
		this.cicloLectivo = cicloLectivo;
	}
	public ArrayList<Comision> getComisiones() {
		return comisiones;
	}
	public void setComisiones(ArrayList<Comision> comisiones) {
		this.comisiones = comisiones;
	}

	






	
	

	
	

}
