package ar.unlam.intraconsulta;

import java.util.ArrayList;

/*Comision: Representa grupos de estudiantes que cursar�n
*  una materia en un ciclo lectivo espec�fico. Tiene asignados 
*  profesores, alumnos, y registros de ex�menes.*/

public class Comision {

	private Integer id;
	private ArrayList<Alumno> alumnoComision = new ArrayList<>();
	private ArrayList<Profesor> profesorComision = new ArrayList<>();
	private Turno turno;
	private Integer dia; /*dias de la semana 1 al 7*/
	private Materia materia;
	private CicloLectivo ciclo; //fecha de inicio
	private Aula nroAula;
	//array de notas por comision
	private ArrayList<Examen> examenes = new ArrayList<>();
	
	
	 
//notas
	public Examen obtenerNota(Integer idAlumno) {
		
		Examen response = null;
		
		for(Examen elemento: this.examenes ) {
			if(elemento.getAlumno().getId() == idAlumno) {
				response = elemento;
				break;				
			}			
		}
		
		return response;
		
		
	}
	
	public boolean registrarNota(Integer idAlumno, Integer puntaje, TipoDeNota tipoNota) {
		// TODO Auto-generated method stub
		
		Boolean returnValue = false;
		Alumno alumno = obtenerAlumnoById(idAlumno);
		ArrayList<Integer> materiasCorrelativas =  this.getMateria().getCorrelativa();
		
		for(Examen examen: this.examenes) {
			
			if(examen.getAlumno().getId() == idAlumno && (tipoNota ==  TipoDeNota.RECUPERATORIO_PRIMER_PARCIAL || tipoNota == TipoDeNota.RECUPERATORIO_SEGUNDO_PARCIAL) &&  (examen.getTipoNota() == TipoDeNota.RECUPERATORIO_PRIMER_PARCIAL 
				 || examen.getTipoNota() == TipoDeNota.RECUPERATORIO_SEGUNDO_PARCIAL)) {
				returnValue = false;
				//break;
				return returnValue;
			}	
			
		}
		
		if(puntaje >= 1 &&	puntaje <= 10) {
			
			if(puntaje >= 7 && materiasCorrelativas.size() > 0) {
				
				ArrayList<Integer> materiasAprovedByAlumno = alumno.getMaterias();
				Integer contador = 0;
				
				for(Integer i = 0; i < materiasAprovedByAlumno.size(); i++ ) {
					
					if(materiasCorrelativas.contains(materiasAprovedByAlumno.get(i))) {
						
						contador++;
						
					}
					
				}
				
				if(contador == materiasCorrelativas.size()) {
					
					returnValue = true;
					
					
				}
				
				
			} else {
				
				returnValue = true;
				
			}
				
		}
		
		
		
		if(returnValue) {
			
			if(tipoNota == TipoDeNota.FINAL) {
				System.out.println("Mensaje desde el if de nota final y agrego la materia en la comision: " + this.getId());
				
				Integer examenAprovado = 0;
				
				for(Examen examen : this.examenes) {
					
					System.out.println("Recorre el for??");
					
					if(examen.getAlumno().getId() == idAlumno) {
						if(examen.getNota().getValor() >= 4) {
							
							examenAprovado++;
							
							
						}
					}
					
				}
				
				System.out.println("Valor de examenAprovado " + examenAprovado);
				
				if(examenAprovado >= 2) {
					
					//generar nota
					Nota nota = new Nota(puntaje, alumno.getId(), materia.getId());
					
					//cargar examen
					Examen newExamen = new Examen(alumno, nota, tipoNota);
					
					this.examenes.add(newExamen);	
					
					if(puntaje >= 4) {
						
						alumno.agregarMateria(materia.getId());
						
					}
					
				} else {
					returnValue = false;
				}
				
			} else {
			
				//generar nota
				Nota nota = new Nota(alumno.getId(), materia.getId(), puntaje);
				
				//cargar examen
				Examen newExamen = new Examen(alumno, nota, tipoNota);
				
				
				this.examenes.add(newExamen);	
				
			}
		}
		
		
		return returnValue;
	}

//registros alumno
	
	public void registrarAlumno(Alumno alumno) {
		this.alumnoComision.add(alumno);
	}
	
	
	
//Metodos complementarios
	
	private Alumno obtenerAlumnoById(Integer id) {
		
		Alumno returnValue = null;
		
		for(Alumno alumno : this.alumnoComision) {
			if (alumno.getId() == id) {
				returnValue = alumno;
				break;
				
			}
		}
		
		return returnValue;
	}
	
	
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

	public ArrayList<Examen> getExamenes() {
		return this.examenes;
	}

	public void setNotas(ArrayList<Examen> examenes) {
		this.examenes = examenes;
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

	public Integer getId() {
		// TODO Auto-generated method stub
		return id;
	}


	public void setId(Integer id) {
		// TODO Auto-generated method stub
		this.id = id;
		
	}
}
