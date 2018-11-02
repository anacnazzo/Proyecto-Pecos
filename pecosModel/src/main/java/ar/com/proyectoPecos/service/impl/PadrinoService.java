package ar.com.proyectoPecos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.proyectoPecos.model.Padrino;
import ar.com.proyectoPecos.repository.IPadrinoRepository;
import ar.com.proyectoPecos.service.IPadrinoService;

@Service
public class PadrinoService implements IPadrinoService{

	@Autowired
	IPadrinoRepository padrinoRepository;

	@Override
	public Padrino findById(Integer id) {
		return padrinoRepository.getOne(id);
	}

	@Override
	public Padrino save(Padrino padrino) {
		return padrinoRepository.save(padrino);
	}

	@Override
	public void delete(Padrino padrino) {
		padrinoRepository.delete(padrino);
	}

	@Override
	public void delete(Integer id) {
		padrinoRepository.deleteById(id);		
	}

	@Override
	public List<Padrino> findAll() {
		return padrinoRepository.findAll();
	}

	@Override
	public List<Padrino> findAll(int page, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

}
