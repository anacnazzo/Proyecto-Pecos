package ar.com.proyectoPecos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ar.com.proyectoPecos.model.Pais;
import ar.com.proyectoPecos.model.Provincia;

@Repository
public interface IProvinciaRepository  extends JpaRepository<Provincia, Integer>{

	@Query("select provincia from Provincia provincia where provincia.pais = ?1")
	List<Provincia> findByPais(Pais pais);
}
