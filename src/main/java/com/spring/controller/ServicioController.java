package com.spring.controller;

import com.spring.model.Servicio;
import com.spring.service.ServicioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/servicios")
public class ServicioController {

    @Autowired
    private ServicioService servicioService;

    @GetMapping
    public String listarServicios(Model model) {
        model.addAttribute("servicios", servicioService.listarTodos());
        return "servicios/listar";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioNuevo(Model model) {
        model.addAttribute("servicio", new Servicio());
        return "servicios/formulario";
    }

    @PostMapping
    public String guardarServicio(@ModelAttribute Servicio servicio) {
        servicioService.guardar(servicio);
        return "redirect:/servicios";
    }

    @GetMapping("/editar/{id}")
    public String editarServicio(@PathVariable Integer id, Model model) {
        Servicio servicio = servicioService.obtenerPorId(id);
        model.addAttribute("servicio", servicio);
        return "servicios/formulario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarServicio(@PathVariable Integer id) {
        servicioService.eliminar(id);
        return "redirect:/servicios";
    }
}
