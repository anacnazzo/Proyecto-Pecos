package ar.com.proyectoPecos.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "LOCALIDADES")
@Data
public class Localidad {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "localidcod")
	private Integer id;

	@Column(name = "localidnom")
	private String nombre;

	@ManyToOne
	@JoinColumn(name = "provincod")
	private Provincia provincia;

	@ManyToOne
	@JoinColumn(name = "paiscod")
	private Pais pais;

	@Column(name = "cp")
	private Integer cp;

}
