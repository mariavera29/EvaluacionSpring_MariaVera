package com.spring.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spring.model.Servicio;
import com.spring.repository.ServicioRepository;

@Service
public class ServicioService {

    @Autowired
    private ServicioRepository servicioRepository;

    public List<Servicio> listarTodos() {
        return servicioRepository.findAll();
    }

    public Servicio guardar(Servicio servicio) {
        return servicioRepository.save(servicio);
    }

    public Servicio obtenerPorId(Integer id) {
        return servicioRepository.findById(id).orElse(null);
    }

    public void eliminar(Integer id) {
        servicioRepository.deleteById(id);
    }
}
