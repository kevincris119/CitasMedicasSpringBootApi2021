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

import com.spring.CitasMedicas.DTO.Sede.SedeDTO;
import com.spring.CitasMedicas.Entity.Sede;
import com.spring.CitasMedicas.Service.SedeService;

@RestController
@RequestMapping("/api/sede")
public class SedeController {
	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private SedeService sedeService;

	@GetMapping
	public ResponseEntity<List<SedeDTO>> ListarTodo() {

		return ResponseEntity.ok(sedeService.ListarTodo().stream().map(x -> modelMapper.map(x, SedeDTO.class))
				.collect(Collectors.toList()));
	}

	@GetMapping("/{id}")
	public ResponseEntity<Sede> ListarPorID(@PathVariable("id") Integer id) {
		return sedeService.ListarPorID(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}

	@PostMapping
	public ResponseEntity<Sede> Guardar(@RequestBody Sede sede) {
		return new ResponseEntity<>(sedeService.Guardar(sede), HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<Sede> Actualizar(@RequestBody Sede sede) {
		return sedeService.ListarPorID(sede.getId_sede()).map(c -> ResponseEntity.ok(sedeService.Actualizar(sede)))
				.orElseGet(() -> ResponseEntity.notFound().build());
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Sede> Eliminar(@PathVariable("id") Integer id) {
		return sedeService.ListarPorID(id).map(c -> {
			sedeService.Eliminar(id);
			return ResponseEntity.ok(c);
		}).orElseGet(() -> ResponseEntity.notFound().build());
	}
}
