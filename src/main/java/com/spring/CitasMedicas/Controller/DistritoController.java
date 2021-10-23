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

import com.spring.CitasMedicas.DTO.Distrito.distritoDTO;
import com.spring.CitasMedicas.Entity.Distrito;
import com.spring.CitasMedicas.Entity.Provincia;
import com.spring.CitasMedicas.Service.DistritoService;

@RestController
@RequestMapping("/api/distrito")
public class DistritoController {
	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private DistritoService areaService;

	/*@GetMapping
	public ResponseEntity<List<distritoDTO>> ListarTodo() {

		return ResponseEntity.ok(areaService.ListarTodo().stream().map(x -> modelMapper.map(x, distritoDTO.class))
				.collect(Collectors.toList()));
	}*/

	@GetMapping("/{id}")
	public ResponseEntity<Distrito> ListarPorID(@PathVariable("id") Integer id) {
		return areaService.ListarPorID(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}
	@GetMapping("/xProvincia/{idProvincia}")
	public ResponseEntity<List<distritoDTO>> ListarPorProvincia(@PathVariable("idProvincia") Integer idProvincia) {
		Provincia provincia=new Provincia();
		provincia.setId_provincia(idProvincia);
		return ResponseEntity.ok(areaService.ListarPorProvincia(provincia).stream().map(x -> modelMapper.map(x, distritoDTO.class))
				.collect(Collectors.toList()));
	}
	@PostMapping
	public ResponseEntity<Distrito> Guardar(@RequestBody Distrito area) {
		return new ResponseEntity<>(areaService.Guardar(area), HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<Distrito> Actualizar(@RequestBody Distrito area) {
		return areaService.ListarPorID(area.getId_distrito()).map(c -> ResponseEntity.ok(areaService.Actualizar(area)))
				.orElseGet(() -> ResponseEntity.notFound().build());
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Distrito> Eliminar(@PathVariable("id") Integer id) {
		return areaService.ListarPorID(id).map(c -> {
			areaService.Eliminar(id);
			return ResponseEntity.ok(c);
		}).orElseGet(() -> ResponseEntity.notFound().build());
	}
}
