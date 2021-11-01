package com.spring.CitasMedicas.Service;

import java.util.List;
import java.util.Optional;

import com.spring.CitasMedicas.Entity.Hora;

public interface IHoraService {

	List<Hora> ListarTodo();

	Optional<Hora> ListarPorID(Integer id);

	Hora Guardar(Hora hora);

	Hora Actualizar(Hora hora);

	void Eliminar(Integer id);
}
