package com.spring.CitasMedicas.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.CitasMedicas.Entity.Cita;
import com.spring.CitasMedicas.Repository.ICitaRepository;

@Service
public class CitaService implements ICitaService {

	@Autowired
	private ICitaRepository citaRepo;

	@Override
	public List<Cita> ListarTodo() {
		// TODO Auto-generated method stub
		return citaRepo.findAll();
	}

	@Override
	public Optional<Cita> ListarPorID(Integer id) {
		// TODO Auto-generated method stub
		return citaRepo.findById(id);
	}

	@Override
	public Cita Guardar(Cita Cita) {
		// TODO Auto-generated method stub
		return citaRepo.save(Cita);
	}

	@Override
	public Cita Actualizar(Cita Cita) {
		// TODO Auto-generated method stub
		return citaRepo.save(Cita);
	}

	@Override
	public void Eliminar(Integer id) {
		// TODO Auto-generated method stub
		citaRepo.deleteById(id);
	}

}
