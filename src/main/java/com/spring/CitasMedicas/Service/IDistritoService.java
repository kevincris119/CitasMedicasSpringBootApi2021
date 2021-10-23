package com.spring.CitasMedicas.Service;

import java.util.List;
import java.util.Optional;

import com.spring.CitasMedicas.Entity.Distrito;

public interface IDistritoService {

	List<Distrito> ListarTodo();

	Optional<Distrito> ListarPorID(Integer id);

	Distrito Guardar(Distrito distrito);

	Distrito Actualizar(Distrito distrito);

	void Eliminar(Integer id);
}
