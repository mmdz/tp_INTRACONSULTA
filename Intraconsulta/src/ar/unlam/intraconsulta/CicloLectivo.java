package ar.unlam.intraconsulta;

/*CicloLectivo: Describe un per�odo acad�mico, con fechas de inicio
 *  y finalizaci�n, as� como fechas para inscripciones.*/
import java.time.LocalDate;

public class CicloLectivo {

	public Integer id;
	public LocalDate fechaDeInicioDeCuatrimestre; //formatear fechas AAAA MM DD
	public LocalDate fechaDeFinDeCuatrimestre;
	public LocalDate fechaDeCierreDeInscripcion;
	public LocalDate fechaDeInicioDeInscripcion;

	public CicloLectivo() {
		
	}	
	
	public CicloLectivo(Integer id, LocalDate fechaDeInicioDeCuatrimestre, LocalDate fechaDeFinDeCuatrimestre,
			LocalDate fechaDeCierreDeInscripcion, LocalDate fechaDeInicioDeInscripcion) {
		this.id = id;
		this.fechaDeInicioDeCuatrimestre = fechaDeInicioDeCuatrimestre;
		this.fechaDeFinDeCuatrimestre = fechaDeFinDeCuatrimestre;
		this.fechaDeCierreDeInscripcion = fechaDeCierreDeInscripcion;
		this.fechaDeInicioDeInscripcion = fechaDeInicioDeInscripcion;
	}



//getter y setter	
	public LocalDate getFechaDeInicioDeCuatrimestre() {
		return fechaDeInicioDeCuatrimestre;
	}
	public void setFechaDeInicioDeCuatrimestre(LocalDate fechaDeInicioDeCuatrimestre) {
		this.fechaDeInicioDeCuatrimestre = fechaDeInicioDeCuatrimestre;
	}
	public LocalDate getFechaDeFinDeCuatrimestre() {
		return fechaDeFinDeCuatrimestre;
	}
	public void setFechaDeFinDeCuatrimestre(LocalDate fechaDeFinDeCuatrimestre) {
		this.fechaDeFinDeCuatrimestre = fechaDeFinDeCuatrimestre;
	}
	public LocalDate getFechaDeCierreDeInscripcion() {
		return fechaDeCierreDeInscripcion;
	}
	public void setFechaDeCierreDeInscripcion(LocalDate fechaDeCierreDeInscripcion) {
		this.fechaDeCierreDeInscripcion = fechaDeCierreDeInscripcion;
	}
	public LocalDate getFechaDeInicioDeInscripcion() {
		return fechaDeInicioDeInscripcion;
	}
	public void setFechaDeInicioDeInscripcion(LocalDate fechaDeInicioDeInscripcion) {

		this.fechaDeInicioDeInscripcion = fechaDeInicioDeInscripcion;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	
	
	
}
