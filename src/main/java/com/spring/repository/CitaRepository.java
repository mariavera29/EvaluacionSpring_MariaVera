package com.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.spring.model.Cita;

@Repository
public interface CitaRepository extends JpaRepository<Cita, Integer> {
}
