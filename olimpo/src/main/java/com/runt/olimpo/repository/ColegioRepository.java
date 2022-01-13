package com.runt.olimpo.repository;

import com.runt.olimpo.entities.Colegio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ColegioRepository extends JpaRepository<Colegio, Long> {
}