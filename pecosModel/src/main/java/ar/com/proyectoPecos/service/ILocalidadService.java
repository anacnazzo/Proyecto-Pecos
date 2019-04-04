package ar.com.proyectoPecos.service;

import java.util.List;

import ar.com.proyectoPecos.model.Localidad;

public interface ILocalidadService {

	Localidad findById(Integer id);

	Localidad save(Localidad localidad);

	void delete(Localidad localidad);

	void delete(Integer id);

	List<Localidad> findAll();

	List<Localidad> findAll(int page, int pageSize);

}
