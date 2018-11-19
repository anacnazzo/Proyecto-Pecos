package ar.com.proyectoPecos.model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "PROFESIONAL")
@PrimaryKeyJoinColumn(name="id")
public class Profesional extends Actor {

	private static final long serialVersionUID = 1L;
	
	Profesional(String email, String password) {
		super(email, password);
	}
	
	
}
