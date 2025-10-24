package com.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.spring.model.Profesional;

@Repository
public interface ProfesionalRepository extends JpaRepository<Profesional, Integer> {
}
