package com.spring.CitasMedicas.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.spring.CitasMedicas.Entity.Usuario;
import com.spring.CitasMedicas.Repository.IUsuarioRepository;

@Service
public class UsuarioService implements IUsuarioService,UserDetailsService {

	@Autowired
	private IUsuarioRepository usuarioRepository;

	@Override
	public List<Usuario> ListarTodo() {
		// TODO Auto-generated method stub
		return usuarioRepository.findAll();
	}
	
	public Usuario ListarPorDni(String dni) {
		// TODO Auto-generated method stub
		return usuarioRepository.findByDni(dni);
	}

	@Override
	public Optional<Usuario> ListarPorID(Integer id) {
		// TODO Auto-generated method stub
		return usuarioRepository.findById(id);
	}

	@Override
	public Usuario Guardar(Usuario usuario) {
		// TODO Auto-generated method stub
		return usuarioRepository.save(usuario);
	}

	@Override
	public Usuario Actualizar(Usuario usuario) {
		// TODO Auto-generated method stub
		return usuarioRepository.save(usuario);
	}

	@Override
	public void Eliminar(Integer id) {
		// TODO Auto-generated method stub
		usuarioRepository.deleteById(id);
	}

	@Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
	
        Usuario user= usuarioRepository.findByDni(username);
        if(user!=null) {
        	return user;
        }else {
        	throw new UsernameNotFoundException("Usuario:"+username+" No Existe");
        }
    }

	

}
