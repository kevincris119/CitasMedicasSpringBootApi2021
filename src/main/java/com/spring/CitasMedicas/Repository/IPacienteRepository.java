package com.spring.CitasMedicas.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.CitasMedicas.Entity.Paciente;

public interface IPacienteRepository extends JpaRepository<Paciente, Integer> {

}
