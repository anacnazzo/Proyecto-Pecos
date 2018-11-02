package ar.com.proyectoPecos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ar.com.proyectoPecos.model.Colaborador;
import ar.com.proyectoPecos.repository.IColaboradorRepository;
import ar.com.proyectoPecos.service.IColaboradorService;

@Service
public class ColaboradorService implements IColaboradorService {

	@Autowired
	IColaboradorRepository colaboradorRepository;

	@Override
	public Colaborador findById(Integer id) {
		return colaboradorRepository.getOne(id);
	}

	@Override
	public Colaborador save(Colaborador colaborador) {
		return colaboradorRepository.save(colaborador);
	}

	@Override
	public void delete(Colaborador colaborador) {
		colaboradorRepository.delete(colaborador);
	}

	@Override
	public void delete(Integer id) {
		colaboradorRepository.deleteById(id);
	}

	@Override
	public List<Colaborador> findAll() {
		return colaboradorRepository.findAll();
	}

	@Override
	public List<Colaborador> findAll(int page, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

}
