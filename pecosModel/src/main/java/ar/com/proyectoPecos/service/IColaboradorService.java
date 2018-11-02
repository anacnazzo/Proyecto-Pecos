package ar.com.proyectoPecos.service;

import java.util.List;

import ar.com.proyectoPecos.model.Colaborador;

public interface IColaboradorService {

	Colaborador findById(Integer id);

	Colaborador save(Colaborador colaborador);

	void delete(Colaborador colaborador);

	void delete(Integer id);

	List<Colaborador> findAll();

	List<Colaborador> findAll(int page, int pageSize);

}
