package ar.unlam.intraconsulta;

import java.util.ArrayList;

public class Materia {
	private Integer id;
	private String nombre;
	private ArrayList<Integer> correlativa = new ArrayList<>();
	
	public Materia(String nombre, Integer id) { 
		this.nombre = nombre;
		this.id = id;		
	}   
	
	//metodo agregarCorrelativa

	public void agregarCorrelativa(Integer id) {
		this.correlativa.add(id);
	}
	
	
	
	//setter y getter
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public ArrayList<Integer> getCorrelativa() {
		return correlativa;
	}
	
	public void setCorrelativa(ArrayList<Integer> corrrelativa){
		this.correlativa = corrrelativa;
	}
	
	
}
