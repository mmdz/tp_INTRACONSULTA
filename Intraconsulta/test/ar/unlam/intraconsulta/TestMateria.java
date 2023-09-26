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
		Materia mobil2 = new Materia("mobil 2", 13);
		
		assertTrue(unlam.registraMateria(mobil));
		assertTrue(unlam.registraMateria(mobil2));
		
		assertTrue(unlam.agregarCorrelatividad(mobil2.getId(), mobil.getId()));
		
		
	}
	
	
	@Test
	public void queNoPuedaAgregarCorrelativa() {
		
		Universidad unlam = new Universidad("unlam");
		Materia mobil = new Materia("mobil 1", 12);
		Materia mobil2 = new Materia("mobil 2", 13);
		
		assertTrue(unlam.registraMateria(mobil));
		assertTrue(unlam.registraMateria(mobil2));
		
		assertFalse(unlam.agregarCorrelatividad(mobil2.getId(), 10));
		
		
	}
	
	@Test
	public void queSePuedaEliminarCorrelativa() {
		
		Universidad unlam = new Universidad("unlam");
		Materia mobil = new Materia("mobil 1", 12);
		Materia mobil2 = new Materia("mobil 2", 13);
		
		assertTrue(unlam.registraMateria(mobil));
		assertTrue(unlam.registraMateria(mobil2));
		
		assertTrue(unlam.agregarCorrelatividad(mobil2.getId(),  mobil.getId()));
		
		//System.out.println(mobil2.getCorrelativa());
		
		
		assertTrue(unlam.eliminarCorrelatividad(mobil2.getId(),  mobil.getId()));
		
		//System.out.println(mobil2.getCorrelativa());
			
	}
	

}
