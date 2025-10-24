package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.spring.model.Usuario;
import com.spring.service.UsuarioService;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "*") 
public class ApiUsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	// Listar todos los usuarios
	@GetMapping
	public List<Usuario> listarUsuarios() {
		return usuarioService.listarTodos();
	}

	// Buscar usuario por ID
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> obtenerUsuario(@PathVariable Integer id) {
		Usuario usuario = usuarioService.obtenerPorId(id);
		if (usuario == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(usuario);
	}

	// Crear un nuevo usuario
	@PostMapping
	public ResponseEntity<Usuario> crearUsuario(@RequestBody Usuario usuario) {
		Usuario nuevo = usuarioService.guardar(usuario);
		return ResponseEntity.ok(nuevo);
	}

	//Actualizar usuario existente
	@PutMapping("/{id}")
	public ResponseEntity<Usuario> actualizarUsuario(@PathVariable Integer id, @RequestBody Usuario datosActualizados) {
		Usuario usuarioExistente = usuarioService.obtenerPorId(id);
		if (usuarioExistente == null) {
			return ResponseEntity.notFound().build();
		}

		usuarioExistente.setNombre(datosActualizados.getNombre());
		usuarioExistente.setEmail(datosActualizados.getEmail());
		usuarioExistente.setTelefono(datosActualizados.getTelefono());
		usuarioExistente.setPassword(datosActualizados.getPassword());

		Usuario actualizado = usuarioService.guardar(usuarioExistente);
		return ResponseEntity.ok(actualizado);
	}

	//Eliminar usuario
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminarUsuario(@PathVariable Integer id) {
		Usuario usuario = usuarioService.obtenerPorId(id);
		if (usuario == null) {
			return ResponseEntity.notFound().build();
		}
		usuarioService.eliminar(id);
		return ResponseEntity.noContent().build();
	}
}
