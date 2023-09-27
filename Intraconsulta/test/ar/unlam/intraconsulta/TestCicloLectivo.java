package ar.unlam.intraconsulta;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

/*No se puede asignar 2 ciclos Lectivo con mismo Id y no se 
pueden superponer los rangos de fechas entre 2 ciclos distintos*/

public class TestCicloLectivo {
 
	@Test
	public void queSePuedaAgregarUnCicloLectivo() {
		
		String nombre = "unlam";
		Universidad unlam = new Universidad("unlam");
		
		Integer idCicloLectivo = 1;		
		LocalDate fechaDeInicioDeCuatrimestre = LocalDate.of(2023, 3, 14);  
		LocalDate fechaDeFinDeCuatrimestre = LocalDate.of(2023, 7, 14);
		LocalDate fechaDeInicioDeInscripcion = LocalDate.of(2023, 2, 25);
		LocalDate fechaDeCierreDeInscripcion = LocalDate.of(2023, 3, 01);

		CicloLectivo ciclo = new CicloLectivo(idCicloLectivo, fechaDeInicioDeCuatrimestre, 
			fechaDeFinDeCuatrimestre, fechaDeCierreDeInscripcion, fechaDeInicioDeInscripcion);
		 
		Boolean estadoDeRegistro = unlam.agregarCicloLectivo(ciclo);
		Boolean esperado = true;
		
		assertEquals(esperado,estadoDeRegistro);
	}

	@Test
	public void queNoSePuedanAgregarDosCiclosLectivosConMismoID() {
		
		String nombre = "unlam";
		Universidad unlam = new Universidad("unlam");
		
		Integer idCicloLectivo = 1;		
		LocalDate fechaDeInicioDeCuatrimestre = LocalDate.of(2023, 3, 14);  
		LocalDate fechaDeFinDeCuatrimestre = LocalDate.of(2023, 7, 14);
		LocalDate fechaDeInicioDeInscripcion = LocalDate.of(2023, 2, 25);
		LocalDate fechaDeCierreDeInscripcion = LocalDate.of(2023, 3, 01);


		CicloLectivo ciclo = new CicloLectivo(idCicloLectivo, fechaDeInicioDeCuatrimestre, 
			fechaDeFinDeCuatrimestre, fechaDeCierreDeInscripcion, fechaDeInicioDeInscripcion);
		CicloLectivo ciclo2 = new CicloLectivo(idCicloLectivo, fechaDeInicioDeCuatrimestre, 
				fechaDeFinDeCuatrimestre, fechaDeCierreDeInscripcion, fechaDeInicioDeInscripcion); 
		
		unlam.agregarCicloLectivo(ciclo);
		
		assertFalse(unlam.agregarCicloLectivo(ciclo2));
	}
	
	@Test
	public void queSeValidenLosRangosDeFechasEnUnMismoCiclo() {
		
		String nombre = "unlam";
		Universidad unlam = new Universidad("unlam");
		
		Integer idCicloLectivo = 1;		
		LocalDate fechaDeInicioDeInscripcion = LocalDate.of(2023, 2, 25); //feb
		LocalDate fechaDeCierreDeInscripcion = LocalDate.of(2023, 3, 20); //mar
		LocalDate fechaDeInicioDeCuatrimestre = LocalDate.of(2023, 4, 14);  //abr
		LocalDate fechaDeFinDeCuatrimestre = LocalDate.of(2023, 7, 14); //jul

		CicloLectivo ciclo = new CicloLectivo(idCicloLectivo, fechaDeInicioDeCuatrimestre, 
			fechaDeFinDeCuatrimestre, fechaDeCierreDeInscripcion, fechaDeInicioDeInscripcion);
			
		unlam.agregarCicloLectivo(ciclo);
		
		Boolean obtenidoFecha = unlam.validarRangoFecha(ciclo);

		Boolean esperado = true;
		assertEquals(esperado,obtenidoFecha);
		
	}
	
	@Test
	public void queNoSePuedanSuperponerLosRangosDeFechasEnUnMismoCiclo() {
		
		String nombre = "unlam";
		Universidad unlam = new Universidad("unlam");
		
		Integer idCicloLectivo = 1;		
		LocalDate fechaDeInicioDeInscripcion = LocalDate.of(2023, 2, 25); //feb
		LocalDate fechaDeCierreDeInscripcion = LocalDate.of(2023, 3, 20); //mar
		/*misma fecha en inicio y fin cursada*/
		LocalDate fechaDeInicioDeCuatrimestre = LocalDate.of(2023, 7, 14);  //jul
		LocalDate fechaDeFinDeCuatrimestre = LocalDate.of(2023, 7, 14); //jul

		CicloLectivo ciclo = new CicloLectivo(idCicloLectivo, fechaDeInicioDeCuatrimestre, 
			fechaDeFinDeCuatrimestre, fechaDeCierreDeInscripcion, fechaDeInicioDeInscripcion);
			
		unlam.agregarCicloLectivo(ciclo);
		
		Boolean obtenidoFecha = unlam.validarRangoFecha(ciclo);

		Boolean esperado = false;
		assertEquals(esperado,obtenidoFecha);
				
	}
	
	@Test
	public void queNoSePuedanSuperponerLosRangosDeFechasEntreDosCiclosDistintos() {
		
		String nombre = "unlam";
		Universidad unlam = new Universidad("unlam");
		
		Integer idCicloLectivo = 1;		
		LocalDate fechaDeInicioDeInscripcion = LocalDate.of(2023, 2, 25);
		LocalDate fechaDeCierreDeInscripcion = LocalDate.of(2023, 3, 01);
		LocalDate fechaDeInicioDeCuatrimestre = LocalDate.of(2023, 4, 14);  
		LocalDate fechaDeFinDeCuatrimestre = LocalDate.of(2023, 7, 14);
	
		CicloLectivo ciclo_1 = new CicloLectivo(idCicloLectivo, fechaDeInicioDeCuatrimestre, 
			fechaDeFinDeCuatrimestre, fechaDeCierreDeInscripcion, fechaDeInicioDeInscripcion);
		
		idCicloLectivo = 2;		
		fechaDeInicioDeInscripcion = LocalDate.of(2023, 7, 14); //se pisan inicio 2C y fin de 1C
		fechaDeCierreDeInscripcion = LocalDate.of(2023, 8, 10);
		fechaDeInicioDeCuatrimestre = LocalDate.of(2023, 8, 20);  
		fechaDeFinDeCuatrimestre = LocalDate.of(2023, 12, 20);
	
		
		CicloLectivo ciclo_2 = new CicloLectivo(idCicloLectivo, fechaDeInicioDeCuatrimestre, 
				fechaDeFinDeCuatrimestre, fechaDeCierreDeInscripcion, fechaDeInicioDeInscripcion); 
		
		unlam.agregarCicloLectivo(ciclo_1);
		unlam.agregarCicloLectivo(ciclo_2);
		
		Boolean estado = unlam.compararFechasDeCiclos(ciclo_1,ciclo_2);

		Boolean esperado = false;
		assertEquals(esperado,estado);	
	}
	
	@Test
	public void queSePuedanCargarDosCiclosDistintos() {
		
		String nombre = "unlam";
		Universidad unlam = new Universidad("unlam");
		
		Integer idCicloLectivo = 1;		
		LocalDate fechaDeInicioDeInscripcion = LocalDate.of(2023, 2, 25);
		LocalDate fechaDeCierreDeInscripcion = LocalDate.of(2023, 3, 01);
		LocalDate fechaDeInicioDeCuatrimestre = LocalDate.of(2023, 4, 14);  
		LocalDate fechaDeFinDeCuatrimestre = LocalDate.of(2023, 7, 14);
	
		CicloLectivo ciclo_1 = new CicloLectivo(idCicloLectivo, fechaDeInicioDeCuatrimestre, 
			fechaDeFinDeCuatrimestre, fechaDeCierreDeInscripcion, fechaDeInicioDeInscripcion);
		
		idCicloLectivo = 2;		
		fechaDeInicioDeInscripcion = LocalDate.of(2023, 7, 20); //se pisan inicio 2C y fin de 1C
		fechaDeCierreDeInscripcion = LocalDate.of(2023, 8, 10);
		fechaDeInicioDeCuatrimestre = LocalDate.of(2023, 8, 20);  
		fechaDeFinDeCuatrimestre = LocalDate.of(2023, 12, 20);
		
		CicloLectivo ciclo_2 = new CicloLectivo(idCicloLectivo, fechaDeInicioDeCuatrimestre, 
				fechaDeFinDeCuatrimestre, fechaDeCierreDeInscripcion, fechaDeInicioDeInscripcion); 
		
		unlam.agregarCicloLectivo(ciclo_1);
		unlam.agregarCicloLectivo(ciclo_2);
		
		Boolean estado = unlam.compararFechasDeCiclos(ciclo_1,ciclo_2);

		Boolean esperado = true;
		assertEquals(esperado,estado);
		
	}
}
