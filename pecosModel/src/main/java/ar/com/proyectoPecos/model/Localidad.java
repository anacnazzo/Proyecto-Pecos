package ar.com.proyectoPecos.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "LOCALIDADES")
public class Localidad {
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="localidcod")
    private Integer id;
	
	@Column(name="localidnom")
    private String nombre;
	
	@ManyToOne
    @JoinColumn(name="provincod")
    private Provincia provincia;
	
	@Column(name="cp")
    private Integer cp;

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

	public Provincia getProvincia() {
		return provincia;
	}

	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}

	public Integer getCp() {
		return cp;
	}

	public void setCp(Integer cp) {
		this.cp = cp;
	}
	
	
	
}
