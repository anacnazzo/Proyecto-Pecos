package ar.com.proyectoPecos.service;

import java.util.List;

import ar.com.proyectoPecos.model.Padrino;

public interface IPadrinoService {

	Padrino findById(Integer id);

	Padrino save(Padrino padrino);

	void delete(Padrino padrino);

	void delete(Integer id);

	List<Padrino> findAll();

	List<Padrino> findAll(int page, int pageSize);

}
