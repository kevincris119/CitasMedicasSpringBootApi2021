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

import com.spring.CitasMedicas.DTO.Hora.HoraDTO;
import com.spring.CitasMedicas.Entity.Hora;
import com.spring.CitasMedicas.Service.HoraService;

@RestController
@RequestMapping("/api/hora")
public class HoraController {
	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private HoraService horaService;

	@GetMapping
	public ResponseEntity<List<HoraDTO>> ListarTodo() {

		return ResponseEntity.ok(horaService.ListarTodo().stream().map(x -> modelMapper.map(x, HoraDTO.class))
				.collect(Collectors.toList()));
	}

	@GetMapping("/{id}")
	public ResponseEntity<Hora> ListarPorID(@PathVariable("id") Integer id) {
		return horaService.ListarPorID(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}

	@PostMapping
	public ResponseEntity<Hora> Guardar(@RequestBody Hora hora) {
		return new ResponseEntity<>(horaService.Guardar(hora), HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<Hora> Actualizar(@RequestBody Hora hora) {
		return horaService.ListarPorID(hora.getId_hora()).map(c -> ResponseEntity.ok(horaService.Actualizar(hora)))
				.orElseGet(() -> ResponseEntity.notFound().build());
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Hora> Eliminar(@PathVariable("id") Integer id) {
		return horaService.ListarPorID(id).map(c -> {
			horaService.Eliminar(id);
			return ResponseEntity.ok(c);
		}).orElseGet(() -> ResponseEntity.notFound().build());
	}
}
