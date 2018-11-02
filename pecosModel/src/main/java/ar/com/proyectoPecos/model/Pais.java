package ar.com.proyectoPecos.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PAISES")
public class Pais {
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="paiscod")
    private Integer id;
	
	@Column(name="paisnom")
    private String nombre;

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
	
	
}
