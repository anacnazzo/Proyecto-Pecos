package ar.com.proyectoPecos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ar.com.proyectoPecos.model.Localidad;
import ar.com.proyectoPecos.model.Provincia;

@Repository
public interface ILocalidadRepository  extends JpaRepository<Localidad, Integer>{
	
	@Query("select localidad from Localidad localidad where localidad.provincia = ?1")
	List<Localidad> findByProvincia(Provincia provincia);
}
