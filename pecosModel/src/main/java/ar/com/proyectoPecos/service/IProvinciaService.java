package ar.com.proyectoPecos.service;

import java.util.List;

import ar.com.proyectoPecos.model.Provincia;

public interface IProvinciaService {

	Provincia findById(Integer id);

	Provincia save(Provincia provincia);

	void delete(Provincia provincia);

	void delete(Integer id);

	List<Provincia> findAll();

	List<Provincia> findAll(int page, int pageSize);

}
