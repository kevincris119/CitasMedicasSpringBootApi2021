package com.spring.CitasMedicas.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.CitasMedicas.Entity.Area;
import com.spring.CitasMedicas.Repository.IAreaRepository;

@Service
public class AreaService implements IAreaService {

	@Autowired
	private IAreaRepository provinciaRepo;

	@Override
	public List<Area> ListarTodo() {
		// TODO Auto-generated method stub
		return provinciaRepo.findAll();
	}

	@Override
	public Optional<Area> ListarPorID(Integer id) {
		// TODO Auto-generated method stub
		return provinciaRepo.findById(id);
	}

	@Override
	public Area Guardar(Area area) {
		// TODO Auto-generated method stub
		return provinciaRepo.save(area);
	}

	@Override
	public Area Actualizar(Area area) {
		// TODO Auto-generated method stub
		return provinciaRepo.save(area);
	}

	@Override
	public void Eliminar(Integer id) {
		// TODO Auto-generated method stub
		provinciaRepo.deleteById(id);
	}

}
