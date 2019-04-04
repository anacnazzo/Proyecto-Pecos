package ar.com.proyectoPecos.controller.dto;

import lombok.Data;

@Data
public class UsuarioDTO {

	private Integer id;

	private String email;

	private String password;

	private String apellido;

	private String nombre;

	private Integer idDni;

	private Integer dni;

	private Integer idCalle;

	private String calle;

	private String numeroCalle;

	private String piso;

	private String depto;

	private Integer idLocalidad;

	private Integer idProvincia;

	private Integer idPais;

	private String telefonoFijo;

	private String telefonoMovil;

}
