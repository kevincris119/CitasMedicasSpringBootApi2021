package com.spring.CitasMedicas.Service;

import java.util.List;
import java.util.Optional;

import com.spring.CitasMedicas.Entity.Personal;

public interface IPersonalService {

	List<Personal> ListarTodo();

	Optional<Personal> ListarPorID(Integer id);

	Personal Guardar(Personal area);

	Personal Actualizar(Personal area);

	void Eliminar(Integer id);
}
