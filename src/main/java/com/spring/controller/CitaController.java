package com.spring.controller;

import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.spring.model.*;
import com.spring.service.*;

@Controller
@RequestMapping("/citas")
public class CitaController {

    @Autowired
    private CitaService citaService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private ProfesionalService profesionalService;

    @Autowired
    private ServicioService servicioService;

    @GetMapping
    public String listarCitas(Model model) {
        model.addAttribute("citas", citaService.listarTodos());
        return "citas/listar";
    }

    @GetMapping("/nueva")
    public String mostrarFormulario(Model model) {
        model.addAttribute("cita", new Cita());
        model.addAttribute("usuarios", usuarioService.listarTodos());
        model.addAttribute("profesionales", profesionalService.listarTodos());
        model.addAttribute("servicios", servicioService.listarTodos());
        return "citas/formulario";
    }

    @PostMapping
    public String guardarCita(@RequestParam("usuarioId") Integer usuarioId,
                              @RequestParam("profesionalId") Integer profesionalId,
                              @RequestParam("servicioId") Integer servicioId,
                              @RequestParam("fechaHora")
                              @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fechaHora,
                              @RequestParam("estado") String estado) {

        Cita cita = new Cita();
        cita.setUsuario(usuarioService.obtenerPorId(usuarioId));
        cita.setProfesional(profesionalService.obtenerPorId(profesionalId));
        cita.setServicio(servicioService.obtenerPorId(servicioId));
        cita.setFechaHora(fechaHora);
        cita.setEstado(estado);

        citaService.guardar(cita);
        return "redirect:/citas";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id) {
        citaService.eliminar(id);
        return "redirect:/citas";
    }
}
