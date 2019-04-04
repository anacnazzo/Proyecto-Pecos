package ar.com.proyectoPecos.service;

import java.util.List;

import ar.com.proyectoPecos.model.Pais;

public interface IPaisService {

	Pais findById(Integer id);

	Pais save(Pais pais);

	void delete(Pais pais);

	void delete(Integer id);

	List<Pais> findAll();

	List<Pais> findAll(int page, int pageSize);

}
