package ar.com.proyectoPecos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ar.com.proyectoPecos.model.Calle;
import ar.com.proyectoPecos.model.Localidad;
import ar.com.proyectoPecos.repository.ICalleRepository;
import ar.com.proyectoPecos.service.ICalleService;

@Service
public class CalleService implements ICalleService {

	@Autowired
	ICalleRepository calleRepository;

	@Override
	public Calle findById(Integer id) {
		return calleRepository.getOne(id);
	}

	@Override
	public Calle save(Calle calle) {
		return calleRepository.save(calle);
	}

	@Override
	public void delete(Calle calle) {
		calleRepository.delete(calle);
	}

	@Override
	public void delete(Integer id) {
		calleRepository.deleteById(id);
	}

	@Override
	public List<Calle> findAll() {
		return calleRepository.findAll();
	}

	@Override
	public List<Calle> findAll(int page, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Calle> findByLocalidad(Localidad localidad) {
		return calleRepository.findByLocalidad(localidad);
	}

}
