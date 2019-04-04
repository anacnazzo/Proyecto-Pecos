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
@Table(name = "DIRECCION")
@Data
public class Direccion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "id_calle")
	private Calle calle;

	@Column(name = "numero_calle")
	private String numeroCalle;

	@Column(name = "piso")
	private String piso;

	@Column(name = "depto")
	private String depto;

	@Column(name = "cp")
	private Integer cp;

}
