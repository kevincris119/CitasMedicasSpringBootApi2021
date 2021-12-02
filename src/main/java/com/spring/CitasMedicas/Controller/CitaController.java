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

import com.spring.CitasMedicas.DTO.Cita.CitaCreacionDTO;
import com.spring.CitasMedicas.DTO.Cita.CitaDTO;
import com.spring.CitasMedicas.Entity.Area;
import com.spring.CitasMedicas.Entity.Cita;
import com.spring.CitasMedicas.Entity.Hora;
import com.spring.CitasMedicas.Entity.Paciente;
import com.spring.CitasMedicas.Entity.Sede;
import com.spring.CitasMedicas.Service.CitaService;

@RestController
@RequestMapping("/api/cita")
public class CitaController {
	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private CitaService CitaService;

	@GetMapping
	public ResponseEntity<List<CitaDTO>> ListarTodo() {
		List<Cita> listCita=CitaService.ListarTodo();
		List<CitaDTO> listCitaDTO=CitaService.ListarTodo().stream().map(x -> modelMapper.map(x, CitaDTO.class)).collect(Collectors.toList());
		return ResponseEntity.ok(CitaService.ListarTodo().stream().map(x -> modelMapper.map(x, CitaDTO.class))
				.collect(Collectors.toList()));
	}

	@GetMapping("/{id}")
	public ResponseEntity<Cita> ListarPorID(@PathVariable("id") Integer id) {
		return CitaService.ListarPorID(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}

	@PostMapping
	public ResponseEntity<CitaCreacionDTO> Guardar(@RequestBody CitaCreacionDTO citaCreacionDTO) {
		Cita cita=modelMapper.map(citaCreacionDTO, Cita.class);
		Sede sede=new Sede();
		sede.setId_sede(citaCreacionDTO.getId_sede());
		Paciente paciente=new Paciente();
		paciente.setId_paciente(citaCreacionDTO.getId_paciente());
		Area area=new Area();
		area.setId_area(citaCreacionDTO.getId_area());
		Hora hora=new Hora();
		hora.setId_hora(citaCreacionDTO.getId_hora());
		
		cita.setSede(sede);
		cita.setPaciente(paciente);
		cita.setArea(area);
		cita.setHora(hora);		
				
		return new ResponseEntity<>(modelMapper.map(CitaService.Guardar(cita), CitaCreacionDTO.class), HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Cita> Actualizar(@RequestBody CitaCreacionDTO citaCreacionDTO,@PathVariable("id") Integer id) {
		Cita cita=modelMapper.map(citaCreacionDTO, Cita.class);
		Sede sede=new Sede();
		sede.setId_sede(citaCreacionDTO.getId_sede());
		Paciente paciente=new Paciente();
		paciente.setId_paciente(citaCreacionDTO.getId_paciente());
		Area area=new Area();
		area.setId_area(citaCreacionDTO.getId_area());
		Hora hora=new Hora();
		hora.setId_hora(citaCreacionDTO.getId_hora());
		
		cita.setSede(sede);
		cita.setPaciente(paciente);
		cita.setArea(area);
		cita.setHora(hora);		
		cita.setId_cita(id);
		return CitaService.ListarPorID(id).map(c -> ResponseEntity.ok(CitaService.Actualizar(cita)))
				.orElseGet(() -> ResponseEntity.notFound().build());
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Cita> Eliminar(@PathVariable("id") Integer id) {
		return CitaService.ListarPorID(id).map(c -> {
			CitaService.Eliminar(id);
			return ResponseEntity.ok(c);
		}).orElseGet(() -> ResponseEntity.notFound().build());
	}
	@GetMapping("listarxPaciente/{idPaciente}")
	public ResponseEntity<List<CitaDTO>> ListarxPaciente(@PathVariable("idPaciente") Integer idPaciente) {
		Paciente paciente=new Paciente();
		paciente.setId_paciente(idPaciente);
		return ResponseEntity.ok(CitaService.ListarxPaciente(paciente).stream().map(x -> modelMapper.map(x, CitaDTO.class))
				.collect(Collectors.toList()));
	}
}
