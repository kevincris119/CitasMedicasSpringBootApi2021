package com.spring.CitasMedicas.Service;

import java.util.List;
import java.util.Optional;

import com.spring.CitasMedicas.Entity.Administrador;

public interface IAdministradorService {

	List<Administrador> ListarTodo();

	Optional<Administrador> ListarPorID(Integer id);

	Administrador Guardar(Administrador administrador);

	Administrador Actualizar(Administrador administrador);

	void Eliminar(Integer id);
}
