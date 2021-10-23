package com.spring.CitasMedicas.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.CitasMedicas.Entity.Distrito;
import com.spring.CitasMedicas.Entity.Provincia;
import com.spring.CitasMedicas.Repository.IDistritoRepository;

@Service
public class DistritoService implements IDistritoService {

	@Autowired
	private IDistritoRepository distritoRepo;

	@Override
	public List<Distrito> ListarTodo() {
		// TODO Auto-generated method stub
		return distritoRepo.findAll();
	}

	@Override
	public Optional<Distrito> ListarPorID(Integer id) {
		// TODO Auto-generated method stub
		return distritoRepo.findById(id);
	}
	
	public List<Distrito> ListarPorProvincia(Provincia provincia) {
		// TODO Auto-generated method stub
		return distritoRepo.findByProvincia(provincia);
	}
	
	@Override
	public Distrito Guardar(Distrito distrito) {
		// TODO Auto-generated method stub
		return distritoRepo.save(distrito);
	}

	@Override
	public Distrito Actualizar(Distrito distrito) {
		// TODO Auto-generated method stub
		return distritoRepo.save(distrito);
	}

	@Override
	public void Eliminar(Integer id) {
		// TODO Auto-generated method stub
		distritoRepo.deleteById(id);
	}

}
