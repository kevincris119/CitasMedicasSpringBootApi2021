package com.spring.CitasMedicas.controller;

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

import com.spring.CitasMedicas.Service.RolesService;
import com.spring.CitasMedicas.entity.Roles;

@RestController
@RequestMapping("/api/roles")
public class RolesController {
	@Autowired
	private RolesService rolService;
	
	@GetMapping
	public ResponseEntity<List<Roles>>ListarTodo(){
		return ResponseEntity.ok(rolService.ListarTodo());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Roles> ListarPorID(@PathVariable("id") Integer id){
		return rolService.ListarPorID(id)
				.map(ResponseEntity::ok)
				.orElseGet(() -> ResponseEntity.notFound().build());
	} 
	
	@PostMapping
	public ResponseEntity<Roles>Guardar(@RequestBody Roles roles){
		return new ResponseEntity<>(rolService.Guardar(roles),HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<Roles> Actualizar(@RequestBody Roles roles){
		return rolService.ListarPorID(roles.getId_roles())
				.map(c-> ResponseEntity.ok(rolService.Actualizar(roles)))
				.orElseGet(()->ResponseEntity.notFound().build());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Roles> Eliminar(@PathVariable("id") Integer id){
		return rolService.ListarPorID(id)
				.map(c-> {
					rolService.Eliminar(id);
					return ResponseEntity.ok(c);
				})
				.orElseGet(()->ResponseEntity.notFound().build());
	}
}
