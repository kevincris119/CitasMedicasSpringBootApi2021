package com.spring.CitasMedicas.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.CitasMedicas.Entity.Personal;
import com.spring.CitasMedicas.Entity.Usuario;
import com.spring.CitasMedicas.Repository.IPersonalRepository;

@Service
public class PersonalService implements IPersonalService {

	@Autowired
	private IPersonalRepository personalRepo;

	@Override
	public List<Personal> ListarTodo() {
		// TODO Auto-generated method stub
		return personalRepo.findAll();
	}
	
	public List<Personal> buscarPorUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		return personalRepo.findByUsuario(usuario);
	}
	@Override
	public Optional<Personal> ListarPorID(Integer id) {
		// TODO Auto-generated method stub
		return personalRepo.findById(id);
	}
	

	@Override
	public Personal Guardar(Personal personal) {
		// TODO Auto-generated method stub
		return personalRepo.save(personal);
	}

	@Override
	public Personal Actualizar(Personal personal) {
		// TODO Auto-generated method stub
		return personalRepo.save(personal);
	}

	@Override
	public void Eliminar(Integer id) {
		// TODO Auto-generated method stub
		personalRepo.deleteById(id);
	}

}
