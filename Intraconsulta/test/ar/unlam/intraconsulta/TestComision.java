package ar.unlam.intraconsulta;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

public class TestComision {

	@Test
	public void queSePuedaAgregarComision() {

		Universidad unlam = new Universidad("unlam");

		Integer idComision = 1;
		Turno turno = Turno.MANIANA;
		Integer dia = 1; /*lunes*/
		
		Comision comision = new Comision(idComision, turno, dia);
		
		Boolean estadoDeRegistro = unlam.registrarComision(comision);
		Boolean esperado = true;
		
		assertEquals(esperado,estadoDeRegistro);	
	}
	//agregar materia a comision
	@Test
	public void queSePuedaAgregarUnaMAteriaAUnaComision(){
		//1ro cargo comision, materia y ciclo
		Universidad unlam = new Universidad("unlam");

		Materia materia = new Materia("pb2", 3000);
		unlam.registraMateria(materia);
		
		Integer idCicloLectivo = 1;		
		LocalDate fechaDeInicioDeCuatrimestre = LocalDate.of(2023, 3, 14);  
		LocalDate fechaDeFinDeCuatrimestre = LocalDate.of(2023, 7, 14);
		LocalDate fechaDeInicioDeInscripcion = LocalDate.of(2023, 2, 25);
		LocalDate fechaDeCierreDeInscripcion = LocalDate.of(2023, 3, 01);
		
		CicloLectivo ciclo = new CicloLectivo(idCicloLectivo, fechaDeInicioDeCuatrimestre, fechaDeFinDeCuatrimestre, fechaDeCierreDeInscripcion, fechaDeInicioDeInscripcion);
		unlam.agregarCicloLectivo(ciclo);
		
		Comision comision_1 = new Comision(1, Turno.MANIANA, 2); //dia martes		
		unlam.registrarComision(comision_1);
		
		Boolean estado =  comision_1.agregarMateriaAComision(comision_1,ciclo, materia,comision_1.getDia());
		assertTrue(estado);

	}		
	
	//agregarComision
	//No se Pueden generar 2 Comisiones para la 
	//misma materia, el mismo cicloLectivo y el mismo turno

	@Test
	public void queNoSePuedaAgregarDosComisionesParaMismaMateriaCicloYTurno(){
		Universidad unlam = new Universidad("unlam");

		Materia materia = new Materia("pb2", 3000);
		unlam.registraMateria(materia);
		
		Integer idCicloLectivo = 1;		
		LocalDate fechaDeInicioDeCuatrimestre = LocalDate.of(2023, 3, 14);  
		LocalDate fechaDeFinDeCuatrimestre = LocalDate.of(2023, 7, 14);
		LocalDate fechaDeInicioDeInscripcion = LocalDate.of(2023, 2, 25);
		LocalDate fechaDeCierreDeInscripcion = LocalDate.of(2023, 3, 01);
		
		CicloLectivo ciclo = new CicloLectivo(idCicloLectivo, fechaDeInicioDeCuatrimestre, fechaDeFinDeCuatrimestre, fechaDeCierreDeInscripcion, fechaDeInicioDeInscripcion);
		unlam.agregarCicloLectivo(ciclo);
		
		Comision comision_1 = new Comision(1, Turno.MANIANA, 2); //dia martes		
		unlam.registrarComision(comision_1);
			
		Comision comision_2 = new Comision(2, Turno.MANIANA, 2); //dia martes		
		unlam.registrarComision(comision_2);
		
		comision_1.agregarMateriaAComision(comision_1,ciclo, materia,comision_1.getDia());
		Boolean estado = comision_2.agregarMateriaAComision(comision_2,ciclo, materia,comision_2.getDia());
		
		assertTrue(estado);
	}
	

	@Test
	public void queSePuedaAgregarDocente() {

		Universidad unlam = new Universidad("unlam");

		Profesor profesor = new Profesor(1111, "Rodriguez", "Jose", LocalDate.of(1980, 01, 20), LocalDate.of(2010, 03, 25));
		unlam.registrarProfesor(profesor);
		
		Comision comision = new Comision(1, Turno.MANIANA, 2); //dia martes
		unlam.registrarComision(comision);
		
		Boolean esperado = comision.agregarProfesorAComision(profesor);

		assertTrue(esperado);
	}
	
	@Test
	public void queNoSePuedaAgregarMismoDocenteAUnaComision() {

		Universidad unlam = new Universidad("unlam");

		Profesor profesor = new Profesor(1111, "Rodriguez", "Jose", LocalDate.of(1980, 01, 20), LocalDate.of(2010, 03, 25));
		unlam.registrarProfesor(profesor);
		
		Comision comision = new Comision(1, Turno.MANIANA, 2); //dia martes
		unlam.registrarComision(comision);
		
		comision.agregarProfesorAComision(profesor);
		Boolean esperado = comision.agregarProfesorAComision(profesor);

		assertFalse(esperado);
	}
	
	
	@Test
	public void queSePuedaAsignarProfesoresAlaComision() {
		
		Universidad unlam = new Universidad("unlam");
		
		Profesor profesor_1 = new Profesor(1111, "Rodriguez", "Jose", LocalDate.of(1980, 01, 20), LocalDate.of(2010, 03, 25));
		unlam.registrarProfesor(profesor_1);
		
		Integer cantidadAlumnos = 15;
		Comision comision = new Comision(1, Turno.MANIANA, 2); //dia martes
		Aula aula = new Aula(1, 100);
		unlam.registrarComision(comision);
		
		comision.getAulas().add(aula);
		comision.getComisiones().add(comision);
		
		Boolean esperado = comision.agregarProfesorAComision(comision, profesor_1,cantidadAlumnos);

		assertTrue(esperado);
	}
	
	@Test
	public void queSePuedaAsignarVAriosProfesoresAlaComision() {
		
		Universidad unlam = new Universidad("unlam");
		
		Profesor profesor_1 = new Profesor(1111, "Rodriguez", "Jose", LocalDate.of(1980, 01, 20), LocalDate.of(2010, 03, 25));
		unlam.registrarProfesor(profesor_1);
		Profesor profesor_2 = new Profesor(2222, "Perez", "Jose", LocalDate.of(1980, 01, 20), LocalDate.of(2010, 03, 25));
		unlam.registrarProfesor(profesor_1);
		unlam.registrarProfesor(profesor_2);

		
		Integer cantidadAlumnos = 25;
		Comision comision = new Comision(1, Turno.MANIANA, 2); //dia martes
		Aula aula = new Aula(1, 100);
		unlam.registrarComision(comision);
		
		comision.getAulas().add(aula);
		comision.getComisiones().add(comision);
		comision.getProfesorComision().add(profesor_1);
		comision.getProfesorComision().add(profesor_2);
		
		comision.agregarProfesorAComision(comision, profesor_1,cantidadAlumnos);
		
		Boolean esperado = comision.agregarProfesorAComision(comision, profesor_2,cantidadAlumnos);

		assertTrue(esperado);
	}
	 /*inscribirAlumnoAComision (dni, idComision)
// Verificar que el alumno y la comisi�n est�n dados de alta
//No se puede inscribir Alumnos si este no tiene aprobadas todas las correlativas. Se aprueba con 4 o m�s.
//La inscripci�n no se puede realizar si esta fuera de fecha Inscripci�n
//No se puede inscribir el alumno si excede la cantidad de alumnos permitidos en el aula
//No se puede inscribir el Alumno si ya est� inscripto a otra comisi�n el mismo d�a y Turno
//No se puede inscribir a una materia que haya aprobado previamente

	  * */
	 
	@Test
	public void queSePuedaAgregarAlumno() {

		Universidad unlam = new Universidad("unlam");

		Alumno alumno = new Alumno(1111, "Rodriguez", "Maria", LocalDate.of(1990, 01, 20), LocalDate.of(2016, 03, 25));
		unlam.registrarAlumno(alumno);
		
		Comision comision = new Comision(1, Turno.MANIANA, 2); //dia martes
		unlam.registrarComision(comision);
		comision.getAlumnosDeComision().add(alumno);
		
		Boolean esperado = comision.agregarAlumnoAComision(alumno, comision);

		assertTrue(esperado);
	}
	
	
	
	
	
	
	
}
