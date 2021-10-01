package com.spring.CitasMedicas.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.CitasMedicas.Entity.Administrador;
import com.spring.CitasMedicas.Repository.IAdministradorRepository;

@Service
public class AdministradorService implements IAdministradorService {

	@Autowired
	private IAdministradorRepository administradorRepo;

	@Override
	public List<Administrador> ListarTodo() {
		// TODO Auto-generated method stub
		return administradorRepo.findAll();
	}

	@Override
	public Optional<Administrador> ListarPorID(Integer id) {
		// TODO Auto-generated method stub
		return administradorRepo.findById(id);
	}

	@Override
	public Administrador Guardar(Administrador administrador) {
		// TODO Auto-generated method stub
		return administradorRepo.save(administrador);
	}

	@Override
	public Administrador Actualizar(Administrador administrador) {
		// TODO Auto-generated method stub
		return administradorRepo.save(administrador);
	}

	@Override
	public void Eliminar(Integer id) {
		// TODO Auto-generated method stub
		administradorRepo.deleteById(id);
	}

}
