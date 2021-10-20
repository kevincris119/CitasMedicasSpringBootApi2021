package com.spring.CitasMedicas.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.CitasMedicas.Entity.Cita;

public interface ICitaRepository extends JpaRepository<Cita, Integer> {

}
