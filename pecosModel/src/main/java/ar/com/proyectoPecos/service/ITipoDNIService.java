package ar.com.proyectoPecos.service;

import java.util.List;

import ar.com.proyectoPecos.model.TipoDNI;

public interface ITipoDNIService {

	TipoDNI findById(Integer id);

	TipoDNI save(TipoDNI tipoDNI);

	void delete(TipoDNI tipoDNI);

	void delete(Integer id);

	List<TipoDNI> findAll();

	List<TipoDNI> findAll(int page, int pageSize);

}
