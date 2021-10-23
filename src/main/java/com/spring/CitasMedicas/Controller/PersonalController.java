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

import com.spring.CitasMedicas.Entity.Personal;
import com.spring.CitasMedicas.Entity.Usuario;
import com.spring.CitasMedicas.Service.PersonalService;

@RestController
@RequestMapping("/api/personal")
public class PersonalController {
	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private PersonalService personalService;

	@GetMapping
	public ResponseEntity<List<Personal>> ListarTodo() {

		return ResponseEntity.ok(personalService.ListarTodo().stream().map(x -> modelMapper.map(x, Personal.class))
				.collect(Collectors.toList()));
	}
	@GetMapping("/xUsuario/{idUsuario}")
	public ResponseEntity<List<Personal>> ListarTodo(@PathVariable("idUsuario") Integer idUsuario) {
		Usuario usuario=new Usuario();
		usuario.setId_usuario(idUsuario);
		return ResponseEntity.ok(personalService.buscarPorUsuario(usuario).stream().map(x -> modelMapper.map(x, Personal.class))
				.collect(Collectors.toList()));
	}
	@GetMapping("/{id}")
	public ResponseEntity<Personal> ListarPorID(@PathVariable("id") Integer id) {
		return personalService.ListarPorID(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}

	@PostMapping
	public ResponseEntity<Personal> Guardar(@RequestBody Personal personal) {
		return new ResponseEntity<>(personalService.Guardar(personal), HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<Personal> Actualizar(@RequestBody Personal personal) {
		return personalService.ListarPorID(personal.getId_personal()).map(c -> ResponseEntity.ok(personalService.Actualizar(personal)))
				.orElseGet(() -> ResponseEntity.notFound().build());
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Personal> Eliminar(@PathVariable("id") Integer id) {
		return personalService.ListarPorID(id).map(c -> {
			personalService.Eliminar(id);
			return ResponseEntity.ok(c);
		}).orElseGet(() -> ResponseEntity.notFound().build());
	}
}
