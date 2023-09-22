package ar.unlam.intraconsulta;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestMateria {

	@Test
	public void queSePuedaAgregarUnaMateriaALaUniverdidad() {
		Universidad unlam = new Universidad("unlam");
		Materia mobil = new Materia("mobil 1", 12);
		
		assertTrue(unlam.registraMateria(mobil));
	}
	
	
	@Test
	public void queNoSePuedaAgregarDosMateriasConElMismoId() {
		Universidad unlam = new Universidad("unlam");
		Materia mobil = new Materia("mobil 1", 12);
		Materia mobil2 = new Materia("mobil 2", 12);
		
		assertTrue(unlam.registraMateria(mobil));
		assertFalse(unlam.registraMateria(mobil2));
		
		
	}
	
	@Test
	public void queSePuedaAgregarCorrelativa() {
		
		Universidad unlam = new Universidad("unlam");
		Materia mobil = new Materia("mobil 1", 12);
		Materia mobil2 = new Materia("mobil 2", 12);
		
		assertTrue(unlam.registraMateria(mobil));
		assertFalse(unlam.registraMateria(mobil2));
		
		
	}
	
	
	

}
