package ar.com.proyectoPecos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ar.com.proyectoPecos.model.Pais;
import ar.com.proyectoPecos.repository.IPaisRepository;
import ar.com.proyectoPecos.service.IPaisService;

@Service
public class PaisService implements IPaisService {

	@Autowired
	IPaisRepository PaisRepository;

	@Override
	public Pais findById(Integer id) {
		return PaisRepository.getOne(id);
	}

	@Override
	public Pais save(Pais pais) {
		return PaisRepository.save(pais);
	}

	@Override
	public void delete(Pais pais) {
		PaisRepository.delete(pais);
	}

	@Override
	public void delete(Integer id) {
		PaisRepository.deleteById(id);
	}

	@Override
	public List<Pais> findAll() {
		return PaisRepository.findAll();
	}

	@Override
	public List<Pais> findAll(int page, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

}
