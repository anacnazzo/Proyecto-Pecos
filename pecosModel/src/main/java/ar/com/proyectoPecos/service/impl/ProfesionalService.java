package ar.com.proyectoPecos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.proyectoPecos.model.Profesional;
import ar.com.proyectoPecos.repository.IProfesionalRepository;
import ar.com.proyectoPecos.service.IProfesionalService;

@Service
public class ProfesionalService implements IProfesionalService {

	@Autowired
	IProfesionalRepository profesionalRepository;

	@Override
	public Profesional findById(Integer id) {
		return profesionalRepository.getOne(id);
	}

	@Override
	public Profesional save(Profesional profesional) {
		return profesionalRepository.save(profesional);
	}

	@Override
	public void delete(Profesional profesional) {
		profesionalRepository.delete(profesional);
	}

	@Override
	public void delete(Integer id) {
		profesionalRepository.deleteById(id);
	}

	@Override
	public List<Profesional> findAll() {
		return profesionalRepository.findAll();
	}

	@Override
	public List<Profesional> findAll(int page, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

}
