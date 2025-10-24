package com.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.model.Profesional;
import com.spring.repository.ProfesionalRepository;

@Service
public class ProfesionalService {

    @Autowired
    private ProfesionalRepository profesionalRepository;

    public List<Profesional> listarTodos() {
        return profesionalRepository.findAll();
    }

    public Optional<Profesional> buscarPorId(Integer id) {
        return profesionalRepository.findById(id);
    }

    public Profesional guardar(Profesional profesional) {
        return profesionalRepository.save(profesional);
    }

    public void eliminar(Integer id) {
        profesionalRepository.deleteById(id);
    }
}
