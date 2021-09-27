package com.spring.CitasMedicas.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.CitasMedicas.Entity.Rol;
import com.spring.CitasMedicas.Repository.IRolesRepository;

@Service
public class RolService implements IRolService {

	@Autowired
	private IRolesRepository rolesRepo;

	@Override
	public List<Rol> ListarTodo() {
		// TODO Auto-generated method stub
		return rolesRepo.findAll();
	}

	@Override
	public Optional<Rol> ListarPorID(Integer id) {
		// TODO Auto-generated method stub
		return rolesRepo.findById(id);
	}

	@Override
	public Rol Guardar(Rol roles) {
		// TODO Auto-generated method stub
		return rolesRepo.save(roles);
	}

	@Override
	public Rol Actualizar(Rol roles) {
		// TODO Auto-generated method stub
		return rolesRepo.save(roles);
	}

	@Override
	public void Eliminar(Integer id) {
		// TODO Auto-generated method stub
		rolesRepo.deleteById(id);
	}

}
