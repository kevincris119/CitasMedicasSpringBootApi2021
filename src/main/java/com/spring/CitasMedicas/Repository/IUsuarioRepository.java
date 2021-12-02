package com.spring.CitasMedicas.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spring.CitasMedicas.DTO.Usuario.loginDTO;
import com.spring.CitasMedicas.Entity.Usuario;
public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {

	Usuario findByDni(String username);
	
	@Query(value="select u.nombre as Nombre,u.apellidos as Apellido,u.dni as Dni,u.contraseña as Contraseña,r.nombre_rol as Nombre_rol, p.id_paciente as Id_Paciente from usuario u join rol r on u.id_rol=r.id_rol join paciente p on p.id_usuario=u.id_usuario where u.dni=?1",nativeQuery = true)
	List<loginDTO> loginDTO(String dni);
	boolean existsByDni(String nombreUsuario);
}
