package com.spring.CitasMedicas.Controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.CitasMedicas.DTO.Usuario.loginCreacionDTO;
import com.spring.CitasMedicas.DTO.Usuario.loginDTO;
import com.spring.CitasMedicas.DTO.Usuario.usuarioCreacionDTO;
import com.spring.CitasMedicas.DTO.Usuario.usuarioDTO;
import com.spring.CitasMedicas.Entity.Distrito;
import com.spring.CitasMedicas.Entity.Rol;
import com.spring.CitasMedicas.Entity.Usuario;
import com.spring.CitasMedicas.Service.UsuarioService;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {
	@Autowired
	private UsuarioService usuarioService;
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	private ModelMapper modelMapper;	
	

	public UsuarioController(UsuarioService usuarioService,BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.usuarioService = usuarioService;
		this.bCryptPasswordEncoder=bCryptPasswordEncoder;
	}
	
	@PostMapping
	public void saveUsuario(@RequestBody usuarioCreacionDTO usuarioCreacionDTO) {
		usuarioCreacionDTO.setContraseña(bCryptPasswordEncoder.encode(usuarioCreacionDTO.getContraseña()));
		Usuario usuario=modelMapper.map(usuarioCreacionDTO, Usuario.class);
		Distrito distrito=new Distrito();
		distrito.setId_distrito(usuarioCreacionDTO.getId_distrito());
		usuario.setDistrito(distrito);
		Rol rol=new Rol();
		rol.setId_rol(3);
		usuario.setRol(rol);
		usuarioService.Guardar(usuario);
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
	public loginDTO buscarUsuario(@RequestBody loginCreacionDTO loginCreacionDTO) {
		return usuarioService.loginDTO(loginCreacionDTO.getDni(),loginCreacionDTO.getContraseña());
	}

}
