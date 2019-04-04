package ar.com.proyectoPecos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ar.com.proyectoPecos.model.TipoDNI;
import ar.com.proyectoPecos.repository.ITipoDNIRepository;
import ar.com.proyectoPecos.service.ITipoDNIService;

@Service
public class TipoDNIService implements ITipoDNIService {

	@Autowired
	ITipoDNIRepository tipoDNIRepository;

	@Override
	public TipoDNI findById(Integer id) {
		return tipoDNIRepository.getOne(id);
	}

	@Override
	public TipoDNI save(TipoDNI tipoDNI) {
		return tipoDNIRepository.save(tipoDNI);
	}

	@Override
	public void delete(TipoDNI tipoDNI) {
		tipoDNIRepository.delete(tipoDNI);
	}

	@Override
	public void delete(Integer id) {
		tipoDNIRepository.deleteById(id);
	}

	@Override
	public List<TipoDNI> findAll() {
		return tipoDNIRepository.findAll();
	}

	@Override
	public List<TipoDNI> findAll(int page, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

}
