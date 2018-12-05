package ar.com.proyectoPecos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ar.com.proyectoPecos.model.Usuario;
import ar.com.proyectoPecos.repository.IUsuarioRepository;
import ar.com.proyectoPecos.service.IUsuarioService;

@Service
public class UsuarioService implements IUsuarioService {

	@Autowired
	IUsuarioRepository usuarioRepository;

	@Override
	public Usuario findById(Integer id) {
		return usuarioRepository.getOne(id);
	}

	@Override
	public Usuario save(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	@Override
	public void delete(Usuario usuario) {
		usuarioRepository.delete(usuario);
	}

	@Override
	public void delete(Integer id) {
		usuarioRepository.deleteById(id);
	}

	@Override
	public List<Usuario> findAll() {
		return usuarioRepository.findAll();
	}
	
	public Integer count() {
		return (int) usuarioRepository.count();
	}

	@Override
	public List<Usuario> findAll(int page, int pageSize) {
		return usuarioRepository.findAll(PageRequest.of(page-1, pageSize, Sort.by("email"))).getContent();
		    
	}

}
