package com.runt.olimpo.repository;

import com.runt.olimpo.entities.Asignatura;
import com.runt.olimpo.entities.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AsignaturaRepository extends JpaRepository<Asignatura, Long> {

    List<Asignatura> findByProfesor(Profesor profesor);

}