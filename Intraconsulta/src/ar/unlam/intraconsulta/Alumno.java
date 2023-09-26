package ar.unlam.intraconsulta;

import java.time.LocalDate;

public class Alumno {
	
	private Integer dni;
	private String apellido;
	private String nombre;
	private LocalDate fechaDeNacimiento; // PONER FORMATO AAAA MM DD
	private LocalDate fechaDeIngreso; // PONER FORMATO AAAA MM DD
 
		
	public Alumno(Integer dni, String apellido, String nombre, LocalDate fechaDeNacimiento, LocalDate fechaDeIngreso) {
		this.dni = dni;
		this.apellido = apellido;
		this.nombre = nombre;
		this.fechaDeNacimiento = fechaDeNacimiento;
		this.fechaDeIngreso = fechaDeIngreso;
	}

	@Override
	public String toString() {
		return "Datos Alumno \n"+"Dni: " + dni + ",\nApellido y nombre: " +
				apellido+" "+ nombre +"\nfecha nac: " + fechaDeNacimiento +
				"\nfecha de ingreso: "+ fechaDeIngreso;
	}
	
	
//getter y setter
	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LocalDate getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}

	public void setFechaDeNacimiento(LocalDate fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}

	public LocalDate getFechaDeIngreso() {
		return fechaDeIngreso;
	}

	public void setFechaDeIngreso(LocalDate fechaDeIngreso) {
		this.fechaDeIngreso = fechaDeIngreso;
	}

	
}
