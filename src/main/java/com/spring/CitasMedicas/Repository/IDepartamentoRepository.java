package com.spring.CitasMedicas.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.CitasMedicas.Entity.Departamento;

public interface IDepartamentoRepository extends JpaRepository<Departamento, String> {
}
