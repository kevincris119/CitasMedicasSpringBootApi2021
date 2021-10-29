package com.spring.CitasMedicas.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.CitasMedicas.Entity.Rol;
import com.spring.CitasMedicas.Service.RolService;

@RestController
@RequestMapping("/api/roles")
public class RolesController {
	@Autowired
	private RolService rolService;

	@GetMapping
	public ResponseEntity<List<Rol>> ListarTodo() {
		return ResponseEntity.ok(rolService.ListarTodo());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Rol> ListarPorID(@PathVariable("id") Integer id) {
		return rolService.ListarPorID(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}

	@PostMapping
	public ResponseEntity<Rol> Guardar(@RequestBody Rol roles) {
		return new ResponseEntity<>(rolService.Guardar(roles), HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<Rol> Actualizar(@RequestBody Rol roles) {
		return rolService.ListarPorID(roles.getId_rol()).map(c -> ResponseEntity.ok(rolService.Actualizar(roles)))
				.orElseGet(() -> ResponseEntity.notFound().build());
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Rol> Eliminar(@PathVariable("id") Integer id) {
		return rolService.ListarPorID(id).map(c -> {
			rolService.Eliminar(id);
			return ResponseEntity.ok(c);
		}).orElseGet(() -> ResponseEntity.notFound().build());
	}
}
