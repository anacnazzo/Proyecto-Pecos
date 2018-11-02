package ar.com.proyectoPecos.model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "COLABORADOR")
@PrimaryKeyJoinColumn(name="id")
public final class Colaborador extends Usuario{
		
	

}
