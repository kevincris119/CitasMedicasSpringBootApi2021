package com.spring.CitasMedicas.Controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
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

import com.spring.CitasMedicas.DTO.ProvinciaDTO;
import com.spring.CitasMedicas.Entity.Administrador;
import com.spring.CitasMedicas.Service.AdministradorService;

@RestController
@RequestMapping("/api/administrador")
public class AdministradorController {
	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private AdministradorService administradorService;

	@GetMapping
	public ResponseEntity<List<ProvinciaDTO>> ListarTodo() {

		return ResponseEntity.ok(administradorService.ListarTodo().stream().map(x -> modelMapper.map(x, ProvinciaDTO.class))
				.collect(Collectors.toList()));
	}

	@GetMapping("/{id}")
	public ResponseEntity<Administrador> ListarPorID(@PathVariable("id") Integer id) {
		return administradorService.ListarPorID(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}

	@PostMapping
	public ResponseEntity<Administrador> Guardar(@RequestBody Administrador administrador) {
		return new ResponseEntity<>(administradorService.Guardar(administrador), HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<Administrador> Actualizar(@RequestBody Administrador administrador) {
		return administradorService.ListarPorID(administrador.getId_administrador()).map(c -> ResponseEntity.ok(administradorService.Actualizar(administrador)))
				.orElseGet(() -> ResponseEntity.notFound().build());
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Administrador> Eliminar(@PathVariable("id") Integer id) {
		return administradorService.ListarPorID(id).map(c -> {
			administradorService.Eliminar(id);
			return ResponseEntity.ok(c);
		}).orElseGet(() -> ResponseEntity.notFound().build());
	}
}
