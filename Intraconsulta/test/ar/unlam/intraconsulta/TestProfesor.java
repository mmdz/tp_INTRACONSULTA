package ar.unlam.intraconsulta;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

public class TestProfesor {
	@Test
	public void queSePuedaAgregarUnProfesorALaUniversidad() {

		String nombre = "unlam";
		Universidad unlam = new Universidad("unlam");
		nombre = "Jose"; 
		String apellido = "Rodriguez";
		Integer dni = 111;
		LocalDate fechaDeNacimiento = LocalDate.of(1980, 01, 20);
		LocalDate fechaDeIngreso =  LocalDate.of(2010, 03, 25);
		Profesor profesor = new Profesor(dni, apellido, nombre, fechaDeNacimiento, fechaDeIngreso);
		
		Boolean estadoDeRegistro = unlam.registrarProfesor(profesor);
		Boolean esperado = true;
		
		assertEquals(esperado,estadoDeRegistro);

	}

	@Test
	public void queNoSePuedanAgregarDosProfesoresConMismoDNIALaUniversidad() {
		
		String nombre = "unlam";
		Universidad unlam = new Universidad("unlam");
		nombre = "Jose";
		String apellido = "Rodriguez";
		Integer dni = 111;
		LocalDate fechaDeNacimiento = LocalDate.of(1980, 01, 20);
		LocalDate fechaDeIngreso =  LocalDate.of(2010, 03, 25);
		
		Profesor profesor = new Profesor(dni, apellido, nombre, fechaDeNacimiento, fechaDeIngreso);
		Profesor profesor2 = new Profesor(dni, apellido, nombre, fechaDeNacimiento, fechaDeIngreso);
		
		unlam.registrarProfesor(profesor);
		assertFalse(unlam.registrarProfesor(profesor2));
			
	}
	
	@Test
	public void queExistaProfesorEnLaUniversidad() {
		
		String nombre = "unlam";
		Universidad unlam = new Universidad("unlam");
		nombre = "Jose";
		String apellido = "Rodriguez";
		Integer dni = 111;
		LocalDate fechaDeNacimiento = LocalDate.of(1980, 01, 20);
		LocalDate fechaDeIngreso =  LocalDate.of(2010, 03, 25);
		
		Profesor profesor = new Profesor(dni, apellido, nombre, fechaDeNacimiento, fechaDeIngreso);		
		unlam.registrarProfesor(profesor);
		
		Boolean estado = unlam.existeProfesor(profesor.getDni());
		
		assertTrue(estado);
	}
	
	@Test
	public void queSePuedaBorrarUnProfesoresDeLaUniversidad() {
		
		String nombre = "unlam";
		Universidad unlam = new Universidad("unlam");
		nombre = "Jose";
		String apellido = "Rodriguez";
		Integer dni = 111;
		LocalDate fechaDeNacimiento = LocalDate.of(1980, 01, 20);
		LocalDate fechaDeIngreso =  LocalDate.of(2010, 03, 25);
		
		Profesor profesor = new Profesor(dni, apellido, nombre, fechaDeNacimiento, fechaDeIngreso);
		unlam.registrarProfesor(profesor);
		
		Boolean estado = unlam.borrarProfesor(profesor);
		assertTrue(estado);
			
	}

}
