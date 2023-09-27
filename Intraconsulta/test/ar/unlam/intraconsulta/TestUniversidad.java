package ar.unlam.intraconsulta;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

public class TestUniversidad {

	@Test
	public void queSePuedaAgregarUnaUniversidad() {
		
		String nombre = "unlam";
		Universidad unlam = new Universidad("unlam");
		
		String esperado = "unlam";
		assertEquals(esperado, nombre);
	}


}
