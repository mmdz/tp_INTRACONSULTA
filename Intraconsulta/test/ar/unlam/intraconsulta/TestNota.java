package ar.unlam.intraconsulta;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

public class TestNota {

	@Test
	public void QueSePuedaRegistrarUnaNota() {
		Materia mobil1 = new Materia("Mobil 1", 1);
		Comision comision = new Comision();
		String nombre = "unlam";
		Universidad unlam = new Universidad("unlam");
		nombre = "Melisa";
		String apellido = "Mendez";
		Integer dni = 111;
		LocalDate fechaDeNacimiento = LocalDate.of(1990, 01, 20);
		LocalDate fechaDeIngreso =  LocalDate.of(2020, 03, 25);
		Alumno alumno = new Alumno(dni, apellido, nombre, fechaDeNacimiento, fechaDeIngreso);
		
		
		unlam.registrarAlumno(alumno);
		
		unlam.registraMateria(mobil1);
		
		unlam.registraComision(comision);
		
		
		
		comision.setId(1);
		alumno.setId(1);
		
		comision.registrarAlumno(alumno);
		
		//agregar materia a comision
		comision.setMateria(mobil1);
		
		assertTrue(comision.registrarNota(alumno.getId(), 5, TipoDeNota.PRIMER_PARCIAL));
	
		
		//assertTrue(unlam.registrarNota(comision.getId(), alumno.getId(), 7, TipoDeNota.PRIMER_PARCIAL));
	
		
	}
	
	@Test
	public void QueNoSePuedaAsignarNotaMayorA7SiNoEstanAprobadasLasCorrelativas() {
		
		Materia mobil1 = new Materia("Mobil 1", 1);
		Materia mobil2 = new Materia("Mobil 2", 2);
		Comision comision = new Comision();
		String nombre = "unlam";
		Universidad unlam = new Universidad("unlam");
		nombre = "Melisa";
		String apellido = "Mendez";
		Integer dni = 111;
		LocalDate fechaDeNacimiento = LocalDate.of(1990, 01, 20);
		LocalDate fechaDeIngreso =  LocalDate.of(2020, 03, 25);
		Alumno alumno = new Alumno(dni, apellido, nombre, fechaDeNacimiento, fechaDeIngreso);
		
		
		unlam.registrarAlumno(alumno);
		
		unlam.registraMateria(mobil1);
		unlam.registraMateria(mobil2);
		
		mobil2.agregarCorrelativa(mobil1.getId());
		
		unlam.registraComision(comision);
		
		
		
		comision.setId(1);
		alumno.setId(1);
		
		comision.registrarAlumno(alumno);
		
		//agregar materia a comision
		comision.setMateria(mobil2);
		
		assertFalse(comision.registrarNota(alumno.getId(), 7, TipoDeNota.PRIMER_PARCIAL));
		
		
		
	}
	
	@Test
	public void QueSePuedaAsignarNotaMayorA7SiEstanAprobadasLasCorrelativas() {
		
		Materia mobil1 = new Materia("Mobil 1", 1);
		Materia mobil2 = new Materia("Mobil 2", 2);
		Comision comision = new Comision();
		Comision comision2 = new Comision();
		String nombre = "unlam";
		Universidad unlam = new Universidad("unlam");
		nombre = "Melisa";
		String apellido = "Mendez";
		Integer dni = 111;
		LocalDate fechaDeNacimiento = LocalDate.of(1990, 01, 20);
		LocalDate fechaDeIngreso =  LocalDate.of(2020, 03, 25);
		Alumno alumno = new Alumno(dni, apellido, nombre, fechaDeNacimiento, fechaDeIngreso);
		
		
		unlam.registrarAlumno(alumno);
		
		unlam.registraMateria(mobil1);
		unlam.registraMateria(mobil2);
		
		mobil2.agregarCorrelativa(mobil1.getId());
		
		unlam.registraComision(comision);
		
		
		
		comision.setId(1);
		comision2.setId(2);
		alumno.setId(1);
		
		comision.registrarAlumno(alumno);
		comision2.registrarAlumno(alumno);
		
		Integer notaValor = 7;
		
		//agregar materia a comision
		comision.setMateria(mobil1);
		comision2.setMateria(mobil2);
		
		assertTrue(comision.registrarNota(alumno.getId(), notaValor, TipoDeNota.PRIMER_PARCIAL));
		assertTrue(comision.registrarNota(alumno.getId(), notaValor, TipoDeNota.SEGUNDO_PARCIAL));
		assertTrue(comision.registrarNota(alumno.getId(), notaValor, TipoDeNota.FINAL));
		
		assertTrue(comision2.registrarNota(alumno.getId(), 7, TipoDeNota.PRIMER_PARCIAL));
		
		
		
	}

}
