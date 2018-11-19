package ar.com.proyectoPecos.model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "PADRINO")
@PrimaryKeyJoinColumn(name="id")
public final class Padrino extends Actor {

	private static final long serialVersionUID = 1L;
	
	Padrino(String email, String password) {
		super(email, password);
	}
}
