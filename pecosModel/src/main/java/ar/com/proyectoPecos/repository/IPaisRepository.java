package ar.com.proyectoPecos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.com.proyectoPecos.model.Pais;

@Repository
public interface IPaisRepository  extends JpaRepository<Pais, Integer>{
}
