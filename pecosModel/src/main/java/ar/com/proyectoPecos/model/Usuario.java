package ar.com.proyectoPecos.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "USUARIO")
@Inheritance (strategy= InheritanceType.JOINED )
public abstract class Usuario {
	
	@Id
	@SequenceGenerator(name="seq-gen",sequenceName="MY_SEQ_GEN",initialValue=205, allocationSize=12)
	@GeneratedValue(strategy= GenerationType.IDENTITY, generator="seq-gen")
	@Column(name="\"ID\"",unique=true,nullable=false)
    private Integer id;

	@Column(name = "email")
	private String email;

	@Column(name = "password")
	private String password;
	
	@Column(name = "validez_desde")
	private Date validezDesde;
	
	@Column(name = "validez_hasta")
	private Date validezHasta;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getValidezDesde() {
		return validezDesde;
	}

	public void setValidezDesde(Date validezDesde) {
		this.validezDesde = validezDesde;
	}

	public Date getValidezHasta() {
		return validezHasta;
	}

	public void setValidezHasta(Date validezHasta) {
		this.validezHasta = validezHasta;
	}
	
	public boolean enabled(Date hoy) {
		if ((hoy.compareTo(validezDesde) >= 0 ) && (hoy.compareTo(validezHasta) <= 0)){
			return true;
		}
		return false;
	}

}
