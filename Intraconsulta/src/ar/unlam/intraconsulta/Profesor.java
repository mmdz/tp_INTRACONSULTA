package ar.unlam.intraconsulta;

import java.time.LocalDate;

public class Profesor {
	private Integer dniProfesor;
	private String apellidoProfesor;
	private String nombreProfesor;
	private LocalDate fechaDeNacimientoProfesor; // PONER FORMATO AAAA MM DD
	private LocalDate fechaDeIngresoProfesor; // PONER FORMATO AAAA MM DD

	
	public Profesor(Integer dniProfesor, String apellidoProfesor, String nombreProfesor,
			LocalDate fechaDeNacimientoProfesor, LocalDate fechaDeIngresoProfesor) {
		this.dniProfesor = dniProfesor;
		this.apellidoProfesor = apellidoProfesor;
		this.nombreProfesor = nombreProfesor;
		this.fechaDeNacimientoProfesor = fechaDeNacimientoProfesor;
		this.fechaDeIngresoProfesor = fechaDeIngresoProfesor;
	}
	
	
//tostring
	@Override
	public String toString() {
		return "Datos Profesor \n"+"Dni: " + dniProfesor + ",\nApellido y nombre: " +
				apellidoProfesor+" "+ nombreProfesor +"\nfecha nac: " + fechaDeNacimientoProfesor +
				"\nfecha de ingreso: "+ fechaDeIngresoProfesor;
	}
	
//getter y setter	
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
