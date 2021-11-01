package com.spring.CitasMedicas.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.CitasMedicas.Entity.Hora;

public interface IHoraRepository extends JpaRepository<Hora, Integer> {

}
