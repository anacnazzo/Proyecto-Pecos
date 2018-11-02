package ar.com.proyectoPecos.service;

import java.util.List;

import ar.com.proyectoPecos.model.Profesional;

public interface IProfesionalService {

	Profesional findById(Integer id);

	Profesional save(Profesional profesional);

	void delete(Profesional profesional);

	void delete(Integer id);

	List<Profesional> findAll();

	List<Profesional> findAll(int page, int pageSize);

}
