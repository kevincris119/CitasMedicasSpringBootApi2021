package com.spring.CitasMedicas.Service;

import java.util.List;
import java.util.Optional;

import com.spring.CitasMedicas.Entity.Rol;

public interface IRolService {

	List<Rol> ListarTodo();

	Optional<Rol> ListarPorID(Integer id);

	Rol Guardar(Rol roles);

	Rol Actualizar(Rol roles);

	void Eliminar(Integer id);
}
