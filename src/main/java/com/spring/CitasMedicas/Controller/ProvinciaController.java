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
import com.spring.CitasMedicas.Entity.Provincia;
import com.spring.CitasMedicas.Service.ProvinciaService;

@RestController
@RequestMapping("/api/provincia")
public class ProvinciaController {
	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private ProvinciaService rolService;

	@GetMapping
	public ResponseEntity<List<ProvinciaDTO>> ListarTodo() {

		return ResponseEntity.ok(rolService.ListarTodo().stream().map(x -> modelMapper.map(x, ProvinciaDTO.class))
				.collect(Collectors.toList()));
	}

	@GetMapping("/{id}")
	public ResponseEntity<Provincia> ListarPorID(@PathVariable("id") Integer id) {
		return rolService.ListarPorID(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}

	@PostMapping
	public ResponseEntity<Provincia> Guardar(@RequestBody Provincia roles) {
		return new ResponseEntity<>(rolService.Guardar(roles), HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<Provincia> Actualizar(@RequestBody Provincia roles) {
		return rolService.ListarPorID(roles.getId_provincia()).map(c -> ResponseEntity.ok(rolService.Actualizar(roles)))
				.orElseGet(() -> ResponseEntity.notFound().build());
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Provincia> Eliminar(@PathVariable("id") Integer id) {
		return rolService.ListarPorID(id).map(c -> {
			rolService.Eliminar(id);
			return ResponseEntity.ok(c);
		}).orElseGet(() -> ResponseEntity.notFound().build());
	}
}
