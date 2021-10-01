package com.spring.CitasMedicas.Controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.CitasMedicas.DTO.UsuarioDTO;
import com.spring.CitasMedicas.Entity.Distrito;
import com.spring.CitasMedicas.Entity.Rol;
import com.spring.CitasMedicas.Entity.Usuario;
import com.spring.CitasMedicas.Service.UsuarioService;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {
	private UsuarioService usuarioService;
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	private ModelMapper modelMapper;
	
	
	

	public UsuarioController(UsuarioService usuarioService,BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.usuarioService = usuarioService;
		this.bCryptPasswordEncoder=bCryptPasswordEncoder;
	}
	
	@PostMapping
	public void saveUsuario(@RequestBody UsuarioDTO usuarioDTO) {
		usuarioDTO.setContraseña(bCryptPasswordEncoder.encode(usuarioDTO.getContraseña()));
		Usuario usuario=modelMapper.map(usuarioDTO, Usuario.class);
		Distrito distrito=new Distrito();
		distrito.setId_distrito(usuarioDTO.getId_distrito());
		usuario.setDistrito(distrito);
		Rol rol=new Rol();
		rol.setId_rol(usuarioDTO.getId_rol());
		
		usuarioService.Guardar(usuario);
	}

	@GetMapping
	public List<Usuario> getAllUsuarios() {
		return usuarioService.ListarTodo();
	}

}
