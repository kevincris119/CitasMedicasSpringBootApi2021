package com.spring.CitasMedicas.Service;

import java.util.List;
import java.util.Optional;

import com.spring.CitasMedicas.DTO.Usuario.loginDTO;
import com.spring.CitasMedicas.Entity.Usuario;

public interface IUsuarioService {

	List<Usuario> ListarTodo();

	Optional<Usuario> ListarPorID(Integer id);

	Usuario Guardar(Usuario usuario);

	Usuario Actualizar(Usuario usuario);

	void Eliminar(Integer id);
	List<loginDTO> loginDTO(String dni,String password);
}
