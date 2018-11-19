package ar.com.proyectoPecos.model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Value;

@Entity
@Table(name = "COLABORADOR")
@PrimaryKeyJoinColumn(name="id")

@Value
@Builder
public final class Colaborador extends Usuario{

	private static final long serialVersionUID = 1L;
		

	Colaborador(@JsonProperty("username") String email,
		       @JsonProperty("password") String password) {
		super(email, password);
	}


}
