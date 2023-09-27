package ar.unlam.intraconsulta;

public class Nota {
 
	private Integer valor;
	private Integer idAlumno;
	private Integer idMateria;
	
	public Nota(Integer alumno, Integer materia, Integer valor) {
		this.valor = valor;
		this.idAlumno = alumno;
		this.idMateria = materia;
		
	}
	
	
	public Integer getValor() {
		return valor;
	}
	
	public void setValor(Integer valor) {
		this.valor = valor;
	}
	
	public Integer getIdAlumno() {
		return idAlumno;
	}
	
	public void setIdAlumno(Integer idAlumno) {
		this.idAlumno = idAlumno;
	}
	
	public Integer getIdMateria() {
		return idMateria;
	}
	
	public void setIdMateria(Integer idMateria) {
		this.idMateria = idMateria;
	}
	
	

}
