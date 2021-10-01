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

import com.spring.CitasMedicas.DTO.AreaDTO;
import com.spring.CitasMedicas.Entity.Area;
import com.spring.CitasMedicas.Service.AreaService;

@RestController
@RequestMapping("/api/area")
public class AreaController {
	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private AreaService areaService;

	@GetMapping
	public ResponseEntity<List<AreaDTO>> ListarTodo() {

		return ResponseEntity.ok(areaService.ListarTodo().stream().map(x -> modelMapper.map(x, AreaDTO.class))
				.collect(Collectors.toList()));
	}

	@GetMapping("/{id}")
	public ResponseEntity<Area> ListarPorID(@PathVariable("id") Integer id) {
		return areaService.ListarPorID(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}

	@PostMapping
	public ResponseEntity<Area> Guardar(@RequestBody Area area) {
		return new ResponseEntity<>(areaService.Guardar(area), HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<Area> Actualizar(@RequestBody Area area) {
		return areaService.ListarPorID(area.getId_area()).map(c -> ResponseEntity.ok(areaService.Actualizar(area)))
				.orElseGet(() -> ResponseEntity.notFound().build());
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Area> Eliminar(@PathVariable("id") Integer id) {
		return areaService.ListarPorID(id).map(c -> {
			areaService.Eliminar(id);
			return ResponseEntity.ok(c);
		}).orElseGet(() -> ResponseEntity.notFound().build());
	}
}
