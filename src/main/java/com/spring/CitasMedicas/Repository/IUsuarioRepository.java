package com.spring.CitasMedicas.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.CitasMedicas.Entity.Usuario;

public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {

	Usuario findByDni(String username);

}
