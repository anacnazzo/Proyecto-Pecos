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
@Table(name = "CALLES")
@Data
public class Calle {
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
    private Integer id;

	@Column(name="nombre")
    private String nombre;
	
	@ManyToOne
    @JoinColumn(name="localidad")
    private Localidad localidad;
	
	@Column(name="tipo")
    private String tipo;
	
	@Column(name="codigo")
    private String codigo;

}
