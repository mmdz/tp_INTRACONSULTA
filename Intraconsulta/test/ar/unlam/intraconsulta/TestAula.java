package ar.unlam.intraconsulta;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

public class TestAula {

	@Test
	public void queSePuedaCrearUnAula() {
		
		Integer idComision = 1;
		Turno turno = Turno.MANIANA;
		Integer dia = 1; /*lunes*/
		
		Comision comision = new Comision(idComision, turno, dia);
		
		Integer numeroDeAula = 130;
		Integer capacidadMaxima = 100;

		Aula aula = new Aula(numeroDeAula, capacidadMaxima);
		
		Boolean estadoDeRegistro = comision.crearAula(aula);
		Boolean esperado = true;
		
		assertEquals(esperado,estadoDeRegistro);
	}
	
	@Test
	public void queSeNoPuedaCrearDosAulasConMismoNumero() {
		
		Integer idComision = 1;
		Turno turno = Turno.MANIANA;
		Integer dia = 1; /*lunes*/
		
		Comision comision = new Comision(idComision, turno, dia);
		
		Integer numeroDeAula = 130;
		Integer capacidadMaxima = 100;
		Aula aula_1 = new Aula(numeroDeAula, capacidadMaxima);
		
		numeroDeAula = 130;
		capacidadMaxima = 100;
		Aula aula_2 = new Aula(numeroDeAula, capacidadMaxima);
		
		comision.crearAula(aula_1);
		Boolean estadoDeRegistro = comision.crearAula(aula_2);
		Boolean esperado = false;
		
		assertEquals(esperado,estadoDeRegistro);
	}
	
	@Test
	public void queNoExcedaLaCapacidadaximaDelAula() {
		
		Universidad unlam = new Universidad("unlam");
		Alumno alumno_1 = new Alumno(1111, "Mendez", "Melisa", LocalDate.of(1990, 01, 20), LocalDate.of(2020, 03, 25));
		unlam.registrarAlumno(alumno_1);
		Alumno alumno_2 = new Alumno(2222, "Gomez", "Ruby", LocalDate.of(1990, 01, 20), LocalDate.of(2020, 03, 25));
		unlam.registrarAlumno(alumno_2);
		
		Integer idComision = 1;
		Turno turno = Turno.MANIANA;
		Integer dia = 1; /*lunes*/
		
		Comision comision = new Comision(idComision, turno, dia);
		
		Integer numeroDeAula = 130;
		Integer capacidadMaxima = 2;

		Aula aula = new Aula(numeroDeAula, capacidadMaxima);
		comision.crearAula(aula);
		
		Boolean estadoDeRegistro = comision.asignarAula(aula, unlam.getAlumnos());
		Boolean esperado = true;
		
		assertEquals(esperado,estadoDeRegistro);
	}
	
	@Test
	public void queExcedaLaCapacidadaximaDelAula() {
		
		Universidad unlam = new Universidad("unlam");
		Alumno alumno_1 = new Alumno(1111, "Mendez", "Melisa", LocalDate.of(1990, 01, 20), LocalDate.of(2020, 03, 25));
		unlam.registrarAlumno(alumno_1);
		
		Alumno alumno_2 = new Alumno(2222, "Gomez", "Ruby", LocalDate.of(1990, 01, 20), LocalDate.of(2020, 03, 25));
		unlam.registrarAlumno(alumno_2);
		
		Integer idComision = 1;
		Turno turno = Turno.MANIANA;
		Integer dia = 1; /*lunes*/
		
		Comision comision = new Comision(idComision, turno, dia);
		
		Integer numeroDeAula = 130;
		Integer capacidadMaxima = 1;

		Aula aula = new Aula(numeroDeAula, capacidadMaxima);
		comision.crearAula(aula);
		
		Boolean estadoDeRegistro = comision.asignarAula(aula, unlam.getAlumnos());
		Boolean esperado = false;
		
		assertEquals(esperado,estadoDeRegistro);
	}

}
