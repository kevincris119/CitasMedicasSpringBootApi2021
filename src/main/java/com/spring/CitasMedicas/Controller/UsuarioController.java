package com.spring.CitasMedicas.Controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.CitasMedicas.DTO.Usuario.RespuestaLoginDTO;
import com.spring.CitasMedicas.DTO.Usuario.loginCreacionDTO;
import com.spring.CitasMedicas.DTO.Usuario.usuarioCreacionDTO;
import com.spring.CitasMedicas.DTO.Usuario.usuarioDTO;
import com.spring.CitasMedicas.Entity.Distrito;
import com.spring.CitasMedicas.Entity.Paciente;
import com.spring.CitasMedicas.Entity.Rol;
import com.spring.CitasMedicas.Entity.Usuario;
import com.spring.CitasMedicas.Service.PacienteService;
import com.spring.CitasMedicas.Service.UsuarioService;
import com.spring.CitasMedicas.Util.Mensaje;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {
	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private PacienteService pacienteService;
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	private ModelMapper modelMapper;

	public UsuarioController(UsuarioService usuarioService, BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.usuarioService = usuarioService;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	@PostMapping
	public ResponseEntity<?> saveUsuario(@RequestBody usuarioCreacionDTO usuarioCreacionDTO) {
		if (usuarioService.existsByNombreUsuario(usuarioCreacionDTO.getDni()))
			return new ResponseEntity(new Mensaje("ese DNI ya existe"), HttpStatus.BAD_REQUEST);
		usuarioCreacionDTO.setContraseña(bCryptPasswordEncoder.encode(usuarioCreacionDTO.getContraseña()));
		Usuario usuario = modelMapper.map(usuarioCreacionDTO, Usuario.class);
		Distrito distrito = new Distrito();
		distrito.setId_distrito(usuarioCreacionDTO.getId_distrito());
		usuario.setDistrito(distrito);
		Rol rol = new Rol();
		rol.setId_rol(3);
		usuario.setRol(rol);
		usuarioService.Guardar(usuario);
		Paciente paciente = new Paciente();
		paciente.setHistoria_clinica("HC" + usuarioCreacionDTO.getDni());
		paciente.setUsuario(usuario);
		pacienteService.Guardar(paciente);
		return new ResponseEntity(new Mensaje("usuario guardado"), HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<usuarioDTO>> getAllUsuarios() {
		return ResponseEntity.ok(usuarioService.ListarTodo().stream().map(x -> modelMapper.map(x, usuarioDTO.class))
				.collect(Collectors.toList()));
	}

	@GetMapping("/{username}")
	public Usuario getUsuario(@PathVariable String username) {
		return usuarioService.ListarPorDni(username);
	}

	@PostMapping("/login")
	public List<RespuestaLoginDTO> buscarUsuario(@RequestBody loginCreacionDTO loginCreacionDTO) {
		var usuario = usuarioService.loginDTO(loginCreacionDTO.getDni());
		List<RespuestaLoginDTO> buscarUsuario = usuarioService.loginDTO(loginCreacionDTO.getDni()).stream()
				.map(x -> modelMapper.map(x, RespuestaLoginDTO.class)).collect(Collectors.toList());
		if (bCryptPasswordEncoder.matches(loginCreacionDTO.getContraseña(), usuario.get(0).getContraseña())) {
			return buscarUsuario;
		} else {
			List<RespuestaLoginDTO> respuestaDTO = Arrays.asList();
			return respuestaDTO;
		}
	}

	@PutMapping("/{idUsuario}")
	public ResponseEntity<Usuario> Actualizar(@RequestBody usuarioCreacionDTO usuarioCreacionDTO,
			@PathVariable("idUsuario") Integer idUsuario) {
		var busqueda = usuarioService.ListarPorID(idUsuario);
		busqueda.get().getRol();
		Usuario usuario = new Usuario();
		Distrito distrito = new Distrito();
		distrito.setId_distrito(usuarioCreacionDTO.getId_distrito());
		usuario.setRol(busqueda.get().getRol());
		usuario.setDistrito(distrito);
		usuario.setNombre(usuarioCreacionDTO.getNombre());
		usuario.setApellidos(usuarioCreacionDTO.getApellidos());
		usuario.setCelular(usuarioCreacionDTO.getCelular());
		usuario.setDni(usuarioCreacionDTO.getDni());
		usuario.setContraseña(bCryptPasswordEncoder.encode(usuarioCreacionDTO.getContraseña()));
		usuario.setFechanacimiento(usuarioCreacionDTO.getFechanacimiento());
		usuario.setId_usuario(idUsuario);
		return usuarioService.ListarPorID(idUsuario).map(c -> ResponseEntity.ok(usuarioService.Actualizar(usuario)))
				.orElseGet(() -> ResponseEntity.notFound().build());
	}

	@DeleteMapping("/{idUsuario}")
	public ResponseEntity<Usuario> Eliminar(@PathVariable("idUsuario") Integer idUsuario) {
		return usuarioService.ListarPorID(idUsuario).map(c -> {
			usuarioService.Eliminar(idUsuario);
			return ResponseEntity.ok(c);
		}).orElseGet(() -> ResponseEntity.notFound().build());
	}

}
