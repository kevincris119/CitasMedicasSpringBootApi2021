package com.spring.CitasMedicas.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.CitasMedicas.Entity.Hora;
import com.spring.CitasMedicas.Repository.IHoraRepository;

@Service
public class HoraService implements IHoraService {

	@Autowired
	private IHoraRepository horaRepo;

	@Override
	public List<Hora> ListarTodo() {
		// TODO Auto-generated method stub
		return horaRepo.findAll();
	}

	@Override
	public Optional<Hora> ListarPorID(Integer id) {
		// TODO Auto-generated method stub
		return horaRepo.findById(id);
	}

	@Override
	public Hora Guardar(Hora area) {
		// TODO Auto-generated method stub
		return horaRepo.save(area);
	}

	@Override
	public Hora Actualizar(Hora area) {
		// TODO Auto-generated method stub
		return horaRepo.save(area);
	}

	@Override
	public void Eliminar(Integer id) {
		// TODO Auto-generated method stub
		horaRepo.deleteById(id);
	}

}
