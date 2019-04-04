package ar.com.proyectoPecos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.proyectoPecos.model.Pais;
import ar.com.proyectoPecos.model.Provincia;
import ar.com.proyectoPecos.repository.IProvinciaRepository;
import ar.com.proyectoPecos.service.IProvinciaService;

@Service
public class ProvinciaService implements IProvinciaService {

	@Autowired
	IProvinciaRepository ProvinciaRepository;

	@Override
	public Provincia findById(Integer id) {
		return ProvinciaRepository.getOne(id);
	}

	@Override
	public Provincia save(Provincia provincia) {
		return ProvinciaRepository.save(provincia);
	}

	@Override
	public void delete(Provincia provincia) {
		ProvinciaRepository.delete(provincia);
	}

	@Override
	public void delete(Integer id) {
		ProvinciaRepository.deleteById(id);
	}

	@Override
	public List<Provincia> findAll() {
		return ProvinciaRepository.findAll();
	}

	@Override
	public List<Provincia> findAll(int page, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Provincia> findByPais(Pais pais) {
		return ProvinciaRepository.findByPais(pais);
	}

}
