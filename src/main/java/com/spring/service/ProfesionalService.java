package com.spring.service;

import java.util.List;
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

    public Profesional guardar(Profesional profesional) {
        return profesionalRepository.save(profesional);
    }

    public Profesional obtenerPorId(Integer id) {
        return profesionalRepository.findById(id).orElse(null);
    }

    public void eliminar(Integer id) {
        profesionalRepository.deleteById(id);
    }
}
