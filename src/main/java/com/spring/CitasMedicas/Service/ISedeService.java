package com.spring.CitasMedicas.Service;

import java.util.List;
import java.util.Optional;

import com.spring.CitasMedicas.Entity.Sede;

public interface ISedeService {

	List<Sede> ListarTodo();

	Optional<Sede> ListarPorID(Integer id);

	Sede Guardar(Sede sede);

	Sede Actualizar(Sede sede);

	void Eliminar(Integer id);
}
