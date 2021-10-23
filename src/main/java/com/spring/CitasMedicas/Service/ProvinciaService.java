package com.spring.CitasMedicas.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.CitasMedicas.Entity.Departamento;
import com.spring.CitasMedicas.Entity.Provincia;
import com.spring.CitasMedicas.Repository.IProvinciaRepository;

@Service
public class ProvinciaService implements IProvinciaService {

	@Autowired
	private IProvinciaRepository provinciaRepo;

	@Override
	public List<Provincia> ListarTodo() {
		// TODO Auto-generated method stub
		return provinciaRepo.findAll();
	}
	public List<Provincia> ListarPorDepartamento(Departamento departamento) {
		// TODO Auto-generated method stub
		return provinciaRepo.findByDepartamento(departamento);
	}

	@Override
	public Optional<Provincia> ListarPorID(Integer id) {
		// TODO Auto-generated method stub
		return provinciaRepo.findById(id);
	}

	@Override
	public Provincia Guardar(Provincia provincia) {
		// TODO Auto-generated method stub
		return provinciaRepo.save(provincia);
	}

	@Override
	public Provincia Actualizar(Provincia provincia) {
		// TODO Auto-generated method stub
		return provinciaRepo.save(provincia);
	}

	@Override
	public void Eliminar(Integer id) {
		// TODO Auto-generated method stub
		provinciaRepo.deleteById(id);
	}

}
