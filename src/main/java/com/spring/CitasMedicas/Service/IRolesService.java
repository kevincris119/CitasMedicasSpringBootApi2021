package com.spring.CitasMedicas.Service;

import java.util.List;
import java.util.Optional;

import com.spring.CitasMedicas.entity.Roles;

public interface IRolesService {

	List<Roles> ListarTodo();
	
	Optional<Roles> ListarPorID(Integer id);
	
	Roles Guardar(Roles roles);
	
	Roles Update(Roles roles);
	
	void Eliminar(Integer id);
}
