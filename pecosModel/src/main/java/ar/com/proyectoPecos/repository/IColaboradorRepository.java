package ar.com.proyectoPecos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.com.proyectoPecos.model.Colaborador;

@Repository
public interface IColaboradorRepository  extends JpaRepository<Colaborador, Integer>{
}
