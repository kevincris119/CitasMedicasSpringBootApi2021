package com.spring.CitasMedicas.Service;

import java.util.List;
import java.util.Optional;

import com.spring.CitasMedicas.Entity.Area;

public interface IAreaService {

	List<Area> ListarTodo();

	Optional<Area> ListarPorID(Integer id);

	Area Guardar(Area area);

	Area Actualizar(Area area);

	void Eliminar(Integer id);
}
