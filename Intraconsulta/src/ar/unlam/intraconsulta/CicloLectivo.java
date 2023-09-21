package ar.unlam.intraconsulta;

/*CicloLectivo: Describe un período académico, con fechas de inicio
 *  y finalización, así como fechas para inscripciones.*/
import java.time.LocalDate;

public class CicloLectivo {

	public LocalDate fechaDeInicioDeCuatrimestre; //formatear fechas AAAA MM DD
	public LocalDate fechaDeFinDeCuatrimestre;
	public LocalDate fechaDeCierreDeInscripcion;
	public LocalDate fechaDeInicioDeInscripcion;
	
	
	
	
	
	
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
	
	
	
	
}
