package com.spring.CitasMedicas.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.CitasMedicas.entity.Roles;
import com.spring.CitasMedicas.repository.IRolesRepository;

@Service
public class RolesService implements IRolesService{

	@Autowired
	private IRolesRepository rolesRepo;
	
	@Override
	public List<Roles> ListarTodo() {
		// TODO Auto-generated method stub
		return rolesRepo.findAll();
	}

	@Override
	public Optional<Roles> ListarPorID(Integer id) {
		// TODO Auto-generated method stub
		return rolesRepo.findById(id);
	}

	@Override
	public Roles Guardar(Roles roles) {
		// TODO Auto-generated method stub
		return rolesRepo.save(roles);
	}

	@Override
	public Roles Actualizar(Roles roles) {
		// TODO Auto-generated method stub
		return rolesRepo.save(roles);
	}

	@Override
	public void Eliminar(Integer id) {
		// TODO Auto-generated method stub
		rolesRepo.deleteById(id);
	}

}
