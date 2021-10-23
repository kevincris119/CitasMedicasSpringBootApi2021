package com.spring.CitasMedicas.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.CitasMedicas.Entity.Departamento;
import com.spring.CitasMedicas.Entity.Provincia;

public interface IProvinciaRepository extends JpaRepository<Provincia, Integer> {
	List<Provincia> findByDepartamento(Departamento departamento);
}
