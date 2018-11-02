package ar.com.proyectoPecos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.com.proyectoPecos.model.Profesional;

@Repository
public interface IProfesionalRepository extends JpaRepository<Profesional, Integer>{
}