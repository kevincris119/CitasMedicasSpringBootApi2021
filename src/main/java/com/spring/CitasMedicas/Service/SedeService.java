package com.spring.CitasMedicas.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.CitasMedicas.Entity.Sede;
import com.spring.CitasMedicas.Repository.ISedeRepository;

@Service
public class SedeService implements ISedeService {

	@Autowired
	private ISedeRepository sedeRepo;

	@Override
	public List<Sede> ListarTodo() {
		// TODO Auto-generated method stub
		return sedeRepo.findAll();
	}

	@Override
	public Optional<Sede> ListarPorID(Integer id) {
		// TODO Auto-generated method stub
		return sedeRepo.findById(id);
	}

	@Override
	public Sede Guardar(Sede area) {
		// TODO Auto-generated method stub
		return sedeRepo.save(area);
	}

	@Override
	public Sede Actualizar(Sede area) {
		// TODO Auto-generated method stub
		return sedeRepo.save(area);
	}

	@Override
	public void Eliminar(Integer id) {
		// TODO Auto-generated method stub
		sedeRepo.deleteById(id);
	}

}
