package com.spring.CitasMedicas.Service;

import java.util.List;
import java.util.Optional;

import com.spring.CitasMedicas.Entity.Departamento;

public interface IDepartamentoService {

	List<Departamento> ListarTodo();

	Optional<Departamento> ListarPorID(String id);

	Departamento Guardar(Departamento area);

	Departamento Actualizar(Departamento area);
}
