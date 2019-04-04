package ar.com.proyectoPecos.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "ACTOR")
@Inheritance(strategy = InheritanceType.JOINED)
@PrimaryKeyJoinColumn(name = "id")
@Data
public abstract class Actor extends Usuario {

	@Column(name = "apellido")
	private String apellido;

	@Column(name = "nombre")
	private String nombre;

	@ManyToOne
	@JoinColumn(name = "id_tipo_dni")
	private TipoDNI tipoDni;

	@Column(name = "dni")
	private Integer dni;

	@OneToOne
	@JoinColumn(name = "id_direccion")
	private Direccion direccion;

	@Column(name = "telefono_fijo")
	private String telefonoFijo;

	@Column(name = "telefono_movil")
	private String telefonoMovil;

}
