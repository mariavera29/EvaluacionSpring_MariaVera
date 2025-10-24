package com.spring.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spring.model.Cita;
import com.spring.repository.CitaRepository;

@Service
public class CitaService {

    @Autowired
    private CitaRepository citaRepository;

    public List<Cita> listarTodos() {
        return citaRepository.findAll();
    }

    public Cita guardar(Cita cita) {
        return citaRepository.save(cita);
    }

    public Cita obtenerPorId(Integer id) {
        return citaRepository.findById(id).orElse(null);
    }

    public void eliminar(Integer id) {
        citaRepository.deleteById(id);
    }
}
