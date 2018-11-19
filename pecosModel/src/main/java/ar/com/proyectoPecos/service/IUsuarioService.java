package ar.com.proyectoPecos.service;

import java.util.List;
import java.util.Optional;

import ar.com.proyectoPecos.model.Usuario;

public interface IUsuarioService {

	Usuario findById(Integer id);

	Usuario save(Usuario usuario);

	void delete(Usuario usuario);

	void delete(Integer id);

	List<Usuario> findAll();

	List<Usuario> findAll(int page, int pageSize);
	
	 /**
	   * Logs in with the given {@code username} and {@code password}.
	   *
	   * @param username
	   * @param password
	   * @return an {@link Optional} of a user when login succeeds
	   */
	  Optional<String> login(String username, String password);

	  /**
	   * Finds a user by its dao-key.
	   *
	   * @param token user dao key
	   * @return
	   */
	  Optional<Usuario> findByToken(String token);

	  /**
	   * Logs out the given input {@code user}.
	   *
	   * @param user the user to logout
	   */
	  void logout(Usuario usuario);

}
