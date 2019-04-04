package ar.com.proyectoPecos.model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "PROFESIONAL")
@PrimaryKeyJoinColumn(name = "id")
public class Profesional extends Actor {

}
