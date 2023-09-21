package ar.unlam.intraconsulta;

import java.time.LocalDate;

public class Profesor {
	private Integer dniProfesor;
	private String apellidoProfesor;
	private String nombreProfesor;
	private LocalDate fechaDeNacimientoProfesor; // PONER FORMATE AAAA MM DD
	private LocalDate fechaDeIngresoProfesor; // PONER FORMATE AAAA MM DD
	
	
	
	
	
	
	public Integer getDni() {
		return dniProfesor;
	}
	public void setDni(Integer dni) {
		this.dniProfesor = dni;
	}
	public String getApellido() {
		return apellidoProfesor;
	}
	public void setApellido(String apellido) {
		this.apellidoProfesor = apellido;
	}
	public String getNombre() {
		return nombreProfesor;
	}
	public void setNombre(String nombre) {
		this.nombreProfesor = nombre;
	}
	public LocalDate getFechaDeNacimiento() {
		return fechaDeNacimientoProfesor;
	}
	public void setFechaDeNacimiento(LocalDate fechaDeNacimiento) {
		this.fechaDeNacimientoProfesor = fechaDeNacimiento;
	}
	public LocalDate getFechaDeIngreso() {
		return fechaDeIngresoProfesor;
	}
	public void setFechaDeIngreso(LocalDate fechaDeIngreso) {
		this.fechaDeIngresoProfesor = fechaDeIngreso;
	}

	
	
	
}
