package com.spring.CitasMedicas.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.CitasMedicas.Entity.Distrito;
import com.spring.CitasMedicas.Entity.Provincia;

public interface IDistritoRepository extends JpaRepository<Distrito, Integer> {
	List<Distrito> findByProvincia(Provincia provincia);
}
