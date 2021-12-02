package com.spring.CitasMedicas.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.CitasMedicas.Entity.Cita;
import com.spring.CitasMedicas.Entity.Paciente;

public interface ICitaRepository extends JpaRepository<Cita, Integer> {
	List<Cita> findByPaciente(Paciente paciente);	
}
