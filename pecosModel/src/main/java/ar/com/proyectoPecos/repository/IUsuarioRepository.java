package ar.com.proyectoPecos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.com.proyectoPecos.model.Usuario;

@Repository
public interface IUsuarioRepository  extends JpaRepository<Usuario, Integer>{
}
