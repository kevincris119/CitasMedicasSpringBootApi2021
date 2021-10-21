package com.spring.CitasMedicas.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.CitasMedicas.Entity.Departamento;
import com.spring.CitasMedicas.Repository.IDepartamentoRepository;

@Service
public class DepartamentoService implements IDepartamentoService {

	@Autowired
	private IDepartamentoRepository departamentoRepo;

	@Override
	public List<Departamento> ListarTodo() {
		// TODO Auto-generated method stub
		return departamentoRepo.findAll();
	}

	@Override
	public Optional<Departamento> ListarPorID(String id) {
		// TODO Auto-generated method stub
		return departamentoRepo.findById(id);
	}

	@Override
	public Departamento Guardar(Departamento area) {
		// TODO Auto-generated method stub
		return departamentoRepo.save(area);
	}

	@Override
	public Departamento Actualizar(Departamento area) {
		// TODO Auto-generated method stub
		return departamentoRepo.save(area);
	}


}
