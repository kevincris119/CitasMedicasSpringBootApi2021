package com.spring.CitasMedicas.Service;

import java.util.List;
import java.util.Optional;

import com.spring.CitasMedicas.Entity.Paciente;

public interface IPacienteService {

	List<Paciente> ListarTodo();

	Optional<Paciente> ListarPorID(Integer id);

	Paciente Guardar(Paciente paciente);

	Paciente Actualizar(Paciente paciente);

	void Eliminar(Integer id);
}
