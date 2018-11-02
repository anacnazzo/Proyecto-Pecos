package ar.com.proyectoPecos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.com.proyectoPecos.model.Padrino;

@Repository
public interface IPadrinoRepository extends JpaRepository<Padrino, Integer>{
}