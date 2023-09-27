package ar.unlam.intraconsulta;

/*// verificar que exista la comisión y el docente
//Cada 20 alumnos se debe agregar un docente ejemplo de 1 a 20 alumnos
 *  solo se puede asignar un docente, de 21 a 40 2 docentes
*/
public class Aula { 
	private Integer numeroAula;
	private Integer capacidadMaxima;
	
	
	
	public Aula(Integer numeroAula, Integer capacidadMaxima) {
		this.numeroAula = numeroAula;
		this.capacidadMaxima = capacidadMaxima;
	}
	
	
	
	
//getter y setter
	public Integer getNumeroAula() {
		return numeroAula;
	}
	public void setNumeroAula(Integer numeroAula) {
		this.numeroAula = numeroAula;
	}
	public Integer getCapacidadMaxima() {
		return capacidadMaxima;
	}
	public void setCapacidadMaxima(Integer capacidadMaxima) {
		this.capacidadMaxima = capacidadMaxima;
	}

	
	
}
