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

@Entity
@Table(name = "ACTOR")
@Inheritance (strategy= InheritanceType.JOINED )
@PrimaryKeyJoinColumn(name="id")
public abstract class Actor extends Usuario{
	
	@Column(name = "apellido")
	private String apellido;

	@Column(name = "nombre")
	private String nombre;
	
	@ManyToOne
    @JoinColumn(name="id_tipo_dni")
    private TipoDNI tipoDni;
	
	@Column(name="dni")
    private Integer dni;

	@OneToOne
    @JoinColumn(name="id_direccion")
    private Direccion direccion;
	
	@Column(name = "telefono_fijo")
	private String telefonoFijo;
	
	@Column(name = "telefono_movil")
	private String telefonoMovil;
	
	

	public Actor() {
		super();
		tipoDni = new TipoDNI();
		direccion = new Direccion();
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

	public TipoDNI getTipoDni() {
		return tipoDni;
	}

	public void setTipoDni(TipoDNI tipoDni) {
		this.tipoDni = tipoDni;
	}
	
	

}
