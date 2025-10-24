package com.spring.controller;

import com.spring.model.Profesional;
import com.spring.model.Usuario;
import com.spring.service.ProfesionalService;
import com.spring.service.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/profesionales")
public class ProfesionalController {

    @Autowired
    private ProfesionalService profesionalService;

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("profesionales", profesionalService.listarTodos());
        return "profesionales/listar";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("profesional", new Profesional());
        model.addAttribute("usuarios", usuarioService.listarTodos());
        return "profesionales/formulario";
    }

    @PostMapping
    public String guardar(
            @ModelAttribute Profesional profesional,
            @RequestParam("usuarioId") Integer usuarioId,
            @RequestParam("horarioDisponible") 
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime horarioDisponible) {

        Usuario usuario = usuarioService.obtenerPorId(usuarioId);
        profesional.setUsuario(usuario);
        profesional.setHorarioDisponible(horarioDisponible);

        profesionalService.guardar(profesional);
        return "redirect:/profesionales";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Integer id, Model model) {
        Profesional profesional = profesionalService.obtenerPorId(id);
        model.addAttribute("profesional", profesional);
        model.addAttribute("usuarios", usuarioService.listarTodos());
        return "profesionales/formulario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id) {
        profesionalService.eliminar(id);
        return "redirect:/profesionales";
    }
}
