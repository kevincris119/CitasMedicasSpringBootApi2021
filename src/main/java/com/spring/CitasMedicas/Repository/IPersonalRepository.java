package com.spring.CitasMedicas.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.CitasMedicas.Entity.Personal;
import com.spring.CitasMedicas.Entity.Usuario;

public interface IPersonalRepository extends JpaRepository<Personal, Integer> {
List<Personal> findByUsuario(Usuario usuario);
}
