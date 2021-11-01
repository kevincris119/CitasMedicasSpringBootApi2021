package com.spring.CitasMedicas.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.CitasMedicas.Entity.Paciente;
import com.spring.CitasMedicas.Repository.IPacienteRepository;

@Service
public class PacienteService implements IPacienteService {

	@Autowired
	private IPacienteRepository pacienteRepo;

	@Override
	public List<Paciente> ListarTodo() {
		// TODO Auto-generated method stub
		return pacienteRepo.findAll();
	}

	@Override
	public Optional<Paciente> ListarPorID(Integer id) {
		// TODO Auto-generated method stub
		return pacienteRepo.findById(id);
	}

	@Override
	public Paciente Guardar(Paciente area) {
		// TODO Auto-generated method stub
		return pacienteRepo.save(area);
	}

	@Override
	public Paciente Actualizar(Paciente area) {
		// TODO Auto-generated method stub
		return pacienteRepo.save(area);
	}

	@Override
	public void Eliminar(Integer id) {
		// TODO Auto-generated method stub
		pacienteRepo.deleteById(id);
	}

}
