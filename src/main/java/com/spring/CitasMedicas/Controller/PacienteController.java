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

import com.spring.CitasMedicas.DTO.Paciente.PacienteDTO;
import com.spring.CitasMedicas.Entity.Paciente;
import com.spring.CitasMedicas.Service.PacienteService;

@RestController
@RequestMapping("/api/paciente")
public class PacienteController {
	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private PacienteService pacienteService;

	@GetMapping
	public ResponseEntity<List<PacienteDTO>> ListarTodo() {

		return ResponseEntity.ok(pacienteService.ListarTodo().stream().map(x -> modelMapper.map(x, PacienteDTO.class))
				.collect(Collectors.toList()));
	}

	@GetMapping("/{id}")
	public ResponseEntity<Paciente> ListarPorID(@PathVariable("id") Integer id) {
		return pacienteService.ListarPorID(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}

	@PostMapping
	public ResponseEntity<Paciente> Guardar(@RequestBody Paciente paciente) {
		return new ResponseEntity<>(pacienteService.Guardar(paciente), HttpStatus.CREATED);
	}
	@PutMapping
	public ResponseEntity<Paciente> Actualizar(@RequestBody Paciente paciente) {
		return pacienteService.ListarPorID(paciente.getId_paciente()).map(c -> ResponseEntity.ok(pacienteService.Actualizar(paciente)))
				.orElseGet(() -> ResponseEntity.notFound().build());
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Paciente> Eliminar(@PathVariable("id") Integer id) {
		return pacienteService.ListarPorID(id).map(c -> {
			pacienteService.Eliminar(id);
			return ResponseEntity.ok(c);
		}).orElseGet(() -> ResponseEntity.notFound().build());
	}
}
