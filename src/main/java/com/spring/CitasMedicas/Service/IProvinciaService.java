package com.spring.CitasMedicas.Service;

import java.util.List;
import java.util.Optional;

import com.spring.CitasMedicas.Entity.Provincia;

public interface IProvinciaService {

	List<Provincia> ListarTodo();

	Optional<Provincia> ListarPorID(Integer id);

	Provincia Guardar(Provincia roles);

	Provincia Actualizar(Provincia roles);

	void Eliminar(Integer id);
}
