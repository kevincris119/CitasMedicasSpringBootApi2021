package com.spring.CitasMedicas.Service;

import java.util.List;
import java.util.Optional;

import com.spring.CitasMedicas.Entity.Cita;

public interface ICitaService {

	List<Cita> ListarTodo();

	Optional<Cita> ListarPorID(Integer id);

	Cita Guardar(Cita cita);

	Cita Actualizar(Cita cita);

	void Eliminar(Integer id);
}
