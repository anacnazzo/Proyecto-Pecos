package ar.com.proyectoPecos.service;

import java.util.List;

import ar.com.proyectoPecos.model.Calle;

public interface ICalleService {

	Calle findById(Integer id);

	Calle save(Calle calle);

	void delete(Calle calle);

	void delete(Integer id);

	List<Calle> findAll();

	List<Calle> findAll(int page, int pageSize);

}
