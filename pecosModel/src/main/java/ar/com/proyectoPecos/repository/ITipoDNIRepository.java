package ar.com.proyectoPecos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.com.proyectoPecos.model.TipoDNI;

@Repository
public interface ITipoDNIRepository  extends JpaRepository<TipoDNI, Integer>{
}
