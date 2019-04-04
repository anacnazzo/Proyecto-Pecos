package ar.com.proyectoPecos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ar.com.proyectoPecos.model.Calle;
import ar.com.proyectoPecos.model.Localidad;


@Repository
public interface ICalleRepository  extends JpaRepository<Calle, Integer>{
	
	@Query("select calle from Calle calle where calle.localidad = ?1")
	List<Calle> findByLocalidad(Localidad localidad);
	
}
