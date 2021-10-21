package com.spring.CitasMedicas.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.CitasMedicas.Entity.Departamento;
import com.spring.CitasMedicas.Service.DepartamentoService;

@RestController
@RequestMapping("/api/departamento")
public class DepartamentoController {
	@Autowired
	private DepartamentoService departamentoService;

	@GetMapping
	public ResponseEntity<List<Departamento>> ListarTodo() {
		return ResponseEntity.ok(departamentoService.ListarTodo());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Departamento> ListarPorID(@PathVariable("id") String id) {
		return departamentoService.ListarPorID(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}

	@PostMapping
	public ResponseEntity<Departamento> Guardar(@RequestBody Departamento departamento) {
		return new ResponseEntity<>(departamentoService.Guardar(departamento), HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<Departamento> Actualizar(@RequestBody Departamento departamento) {
		return departamentoService.ListarPorID(departamento.getId_departamento()).map(c -> ResponseEntity.ok(departamentoService.Actualizar(departamento)))
				.orElseGet(() -> ResponseEntity.notFound().build());
	}

	
}
