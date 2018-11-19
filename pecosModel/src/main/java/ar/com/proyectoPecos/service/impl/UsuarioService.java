package ar.com.proyectoPecos.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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

	@Override
	public List<Usuario> findAll(int page, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<String> login(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Usuario> findByToken(String token) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void logout(Usuario usuario) {
		// TODO Auto-generated method stub
		
	}

}
