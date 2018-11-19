package ar.com.proyectoPecos.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Value;

@Entity
@Table(name = "ACTOR")
@Inheritance (strategy= InheritanceType.JOINED )
@PrimaryKeyJoinColumn(name="id")

@Value
@Builder
public abstract class Actor extends Usuario{
	
	private static final long serialVersionUID = 1L;

	@Column(name = "apellido")
	private String apellido;

	@Column(name = "nombre")
	private String nombre;
	
	@Column(name="dni")
    private Integer dni;

	@OneToOne
    @JoinColumn(name="id_direccion")
    private Direccion direccion;
	
	@Column(name = "telefono_fijo")
	private String telefonoFijo;
	
	@Column(name = "telefono_movil")
	private String telefonoMovil;
	
	Actor(@JsonProperty("username") String email,
		       @JsonProperty("password") String password) {
		super(email, password);
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

	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public String getTelefonoFijo() {
		return telefonoFijo;
	}

	public void setTelefonoFijo(String telefonoFijo) {
		this.telefonoFijo = telefonoFijo;
	}

	public String getTelefonoMovil() {
		return telefonoMovil;
	}

	public void setTelefonoMovil(String telefonoMovil) {
		this.telefonoMovil = telefonoMovil;
	}

}
