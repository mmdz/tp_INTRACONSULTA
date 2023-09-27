package ar.unlam.intraconsulta;

import java.util.ArrayList;

/*Comision: Representa grupos de estudiantes que cursar�n
*  una materia en un ciclo lectivo espec�fico. Tiene asignados 
*  profesores, alumnos, y registros de ex�menes.*/

public class Comision {

	
	private Integer id;
	private Turno turno;
	private Integer dia; /*dias de la semana 1 al 7*/
	private ArrayList<Alumno> alumnosDeComision = new ArrayList<>();
	private ArrayList<Profesor> profesorComision = new ArrayList<>();	
	private Materia materia ;
	private CicloLectivo ciclo; //fecha de inicio
	private ArrayList<Aula> aulas = new ArrayList<>();	
	//private ArrayList<Nota> notas = new ArrayList<>();
	private ArrayList<Comision> comisiones = new ArrayList<Comision>();
	private ArrayList<Examen> examenes = new ArrayList<>();
	
	
	public Comision(Integer id,Turno turno, Integer dia) {
		this.id = id;
		this.turno = turno;
		this.dia = dia;  /*dias de la semana 1 al 7*/
	}

//COMISION
	
	

	public Boolean agregarMateriaAComision(Comision comision,CicloLectivo ciclo2, Materia materia2, Integer dia) {
		// TODO Auto-generated method stub
		Boolean estado = true;

		for (int i = 0; i < this.comisiones.size(); i++) {
			if (this.comisiones.get(i).getMateria().equals(materia2) &&
				this.comisiones.get(i).getCiclo().id.equals(ciclo2) &&
				this.comisiones.get(i).getDia().equals(dia) ) {
				
			   estado = false;

			}		
			 this.setMateria(materia2);
			 this.setDia(dia);
			 this.setCiclo(ciclo2);
			 this.setId(id);
			 comisiones.add(comision);
		 	 estado =  true;		
		} return estado;
		
	}

		
//AULA	
	public Boolean crearAula(Aula aula) {
		//que no este duplicada
		if(buscarAulaPorNumero(aula.getNumeroAula()) == null){
			return this.aulas.add(aula);
		}
		return false;
	}
	
	public Boolean asignarAula(Aula aula, ArrayList<Alumno> alumnos) {
		/*si existe y hay lugar la asigna*/
		if(buscarAulaPorNumero(aula.getNumeroAula()).equals(aula) &&
		   aula.getCapacidadMaxima() >= alumnos.size()) {
			
			return this.aulas.add(aula);
		}
		return false;
	}

	
	public Aula buscarAulaPorNumero(Integer numeroAula) {
		for (int i = 0; i < aulas.size(); i++) {
			if (this.aulas.get(i).getNumeroAula().equals(numeroAula))
				return this.aulas.get(i);
		}		
		return null;
	}

//PROFESOR
	public Boolean agregarProfesorAComision(Profesor profesor) {
		// TODO Auto-generated method stub
		if(buscarProfesorPorDni(profesor.getDni()) == null) {					
			return this.profesorComision.add(profesor);
		}
		 return false;
	}
	
	public Profesor buscarProfesorPorDni(Integer idProfesor) {
		for (int i = 0; i < profesorComision.size(); i++) {
			if (this.profesorComision.get(i).getDni().equals(idProfesor))
				return this.profesorComision.get(i);
		}		
		return null;
	}

	public Boolean agregarProfesorAComision(Comision idComision, Profesor dni, Integer cantidadAlumnos) {
		// TODO Auto-generated method stub
		Boolean existe = true;
		for (int i = 0; i < comisiones.size(); i++) {
			if (this.comisiones.get(i).getId().equals(idComision.id))
				existe = true;
		}	existe = false;
			
		if (this.buscarProfesorPorDni(dni.getDni()) != null && existe == true) {			
			if(cantidadAlumnos >= 1 && cantidadAlumnos <=20) {
				return this.profesorComision.add(dni);					
			} if(cantidadAlumnos >= 21 && cantidadAlumnos <=40 && this.profesorComision.size() < 2) 
				return this.profesorComision.add(dni);		

		} 
		return false;
	}

//alumno
	public Boolean agregarAlumnoAComision(Alumno dni, Comision id2) {
		// TODO Auto-generated method stub
		Boolean existeComision = true;
		Boolean existeAlumno = true;

		for (int i = 0; i < comisiones.size(); i++) {
			if (this.comisiones.get(i).getId().equals(id2.getId()))
				existeComision = true;
		}		existeComision = false;
		
		for (int i = 0; i < this.alumnosDeComision.size(); i++) {
			if (this.alumnosDeComision.get(i).getDni().equals(dni.getDni()))
				existeAlumno = true;
			}	existeAlumno = false;
		
		if(existeAlumno ==true && existeComision == true) {
			this.getAlumnosDeComision().add(dni);
			return true;
		}
		
		return null;
	}
	
//	public Boolean registrarAlumno(Alumno alumno) {
//		if (buscarAlumnoPorDni(alumno.getDni()) == null)		
//			return this.alumnos.add(alumno);
//		return false;
//	}
//
//	public Alumno buscarAlumnoPorDni(Integer dni) {
//		for (int i = 0; i < alumnos.size(); i++) {
//			if (this.alumnos.get(i).getDni().equals(dni))
//				return this.alumnos.get(i);
//		}		
//		return null;
//	} 
//
//	public Boolean existeAlumno(Integer dni) {
//		for (int i = 0; i < alumnos.size(); i++) {
//			if (this.alumnos.get(i).getDni().equals(dni))
//				return true;
//		}
//		return false;
//	}
	
	
				 
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
	
	
//Metodos complementarios
	
	private Alumno obtenerAlumnoById(Integer id) {
		
		Alumno returnValue = null;
		
		for(Alumno alumno : this.getAlumnosDeComision()) {
			if (alumno.getId() == id) {
				returnValue = alumno;
				break;
				
			}
		}
		
		return returnValue;
	}
					
	
//getter y setter
	public ArrayList<Alumno> getAlumnoComision() {
		return alumnosDeComision;
	}

	public void setAlumnoComision(ArrayList<Alumno> alumnoComision) {

		this.alumnosDeComision = alumnoComision;
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
	
	public ArrayList<Aula> getNroAula() {

		return aulas;
	}

	
	public void setNroAula(ArrayList<Aula> nroAula) {

		this.aulas = nroAula;
	}

	
	public void setDia(Integer dia) {
		this.dia = dia;
	}
	
	public Integer getDia() {
		return dia;
	}



	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {

		this.id = id;
	}

	public ArrayList<Alumno> getAlumnosDeComision() {
		return alumnosDeComision;
	}

	public void setAlumnosDeComision(ArrayList<Alumno> alumnosDeComision) {
		this.alumnosDeComision = alumnosDeComision;
	}

	public CicloLectivo getCiclo() {
		return ciclo;
	}

	public void setCiclo(CicloLectivo ciclo) {
		this.ciclo = ciclo;
	}

	public ArrayList<Aula> getAulas() {
		return aulas;
	}

	public void setAulas(ArrayList<Aula> aulas) {
		this.aulas = aulas;
	}
	
	public ArrayList<Comision> getComisiones() {
		return comisiones;
	}
	
	public void setComisiones(ArrayList<Comision> comisiones) {
		this.comisiones = comisiones;
	}

}





	



