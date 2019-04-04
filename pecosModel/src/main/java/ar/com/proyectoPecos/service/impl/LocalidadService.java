package ar.com.proyectoPecos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ar.com.proyectoPecos.model.Localidad;
import ar.com.proyectoPecos.model.Provincia;
import ar.com.proyectoPecos.repository.ILocalidadRepository;
import ar.com.proyectoPecos.service.ILocalidadService;

@Service
public class LocalidadService implements ILocalidadService {

	@Autowired
	ILocalidadRepository localidadRepository;

	@Override
	public Localidad findById(Integer id) {
		return localidadRepository.getOne(id);
	}

	@Override
	public Localidad save(Localidad localidad) {
		return localidadRepository.save(localidad);
	}

	@Override
	public void delete(Localidad localidad) {
		localidadRepository.delete(localidad);
	}

	@Override
	public void delete(Integer id) {
		localidadRepository.deleteById(id);
	}

	@Override
	public List<Localidad> findAll() {
		return localidadRepository.findAll();
	}

	@Override
	public List<Localidad> findAll(int page, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Localidad> findByProvincia(Provincia provincia) {
		return localidadRepository.findByProvincia(provincia);
	}

}
