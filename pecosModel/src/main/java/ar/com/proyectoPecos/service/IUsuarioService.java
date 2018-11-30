package ar.com.proyectoPecos.service;

import java.util.List;

import ar.com.proyectoPecos.model.Usuario;

public interface IUsuarioService {

	Usuario findById(Integer id);

	Usuario save(Usuario usuario);

	void delete(Usuario usuario);

	void delete(Integer id);

	List<Usuario> findAll();

	List<Usuario> findAll(int page, int pageSize);

}
