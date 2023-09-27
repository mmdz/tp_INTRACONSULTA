package ar.unlam.intraconsulta;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

public class TestAlumno {
	
	@Test
	public void queSePuedaAgregarUnAlumnoALaUniversidad() {
		//preparacion
		String nombre = "unlam";
		Universidad unlam = new Universidad("unlam");
		nombre = "Melisa";
		String apellido = "Mendez";
		Integer dni = 111;
		LocalDate fechaDeNacimiento = LocalDate.of(1990, 01, 20);
		LocalDate fechaDeIngreso =  LocalDate.of(2020, 03, 25);
		Alumno alumno = new Alumno(dni, apellido, nombre, fechaDeNacimiento, fechaDeIngreso);
		 
		//ejecucion
		Boolean estadoDeRegistro = unlam.registrarAlumno(alumno);
		Boolean esperado = true; 
		
		//validacion
		//assertTrue(unlam.registrarAlumno(alumno));
		assertEquals(esperado,estadoDeRegistro);

	}
 
	
	@Test
	public void queNoSePuedanAgregarDosAlumnosConMismoDNIALaUniversidad() {
		
		String nombre = "unlam";
		Universidad unlam = new Universidad("unlam");
		nombre = "Melisa";
		String apellido = "Mendez";
		Integer dni = 111;
		LocalDate fechaDeNacimiento = LocalDate.of(1990, 01, 20);
		LocalDate fechaDeIngreso =  LocalDate.of(2020, 03, 25);
		
		Alumno alumno = new Alumno(dni, apellido, nombre, fechaDeNacimiento, fechaDeIngreso);
		Alumno alumno2 = new Alumno(dni, apellido, nombre, fechaDeNacimiento, fechaDeIngreso);

		unlam.registrarAlumno(alumno);
		Boolean obtenido = unlam.registrarAlumno(alumno2);
		
		assertFalse(obtenido);
	}
	
	@Test
	public void queSePuedaBorrarUnAlumnoDeLaUniversidad() {
		
		String nombre = "unlam";
		Universidad unlam = new Universidad("unlam");
		nombre = "Melisa";
		String apellido = "Mendez";
		Integer dni = 111;
		LocalDate fechaDeNacimiento = LocalDate.of(1990, 01, 20);
		LocalDate fechaDeIngreso =  LocalDate.of(2020, 03, 25);
		
		Alumno alumno = new Alumno(dni, apellido, nombre, fechaDeNacimiento, fechaDeIngreso);
		unlam.registrarAlumno(alumno);
		
		Boolean estado = unlam.borrarAlumno(alumno);
		assertTrue(estado);
			
	}
	
	@Test
	public void queExistaUnAlumnoEnLaUniversidad() {
		
		String nombre = "unlam";
		Universidad unlam = new Universidad("unlam");
		nombre = "Melisa";
		String apellido = "Mendez";
		Integer dni = 111;
		LocalDate fechaDeNacimiento = LocalDate.of(1990, 01, 20);
		LocalDate fechaDeIngreso =  LocalDate.of(2020, 03, 25);
		
		Alumno alumno = new Alumno(dni, apellido, nombre, fechaDeNacimiento, fechaDeIngreso);
		unlam.registrarAlumno(alumno);

		Boolean estado = unlam.existeAlumno(dni);
		
		assertTrue(estado);
	}
}
