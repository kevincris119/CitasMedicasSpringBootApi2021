package com.spring.CitasMedicas.DTO;

import java.sql.Date;

import com.spring.CitasMedicas.Entity.Distrito;
import com.spring.CitasMedicas.Entity.Rol;

import lombok.Data;


public class Usuario {
	@Data
	public static class usuarioDTO{
		
		private Integer id_usuario;
		private String nombre;

		private String apellidos;

		private Date fechanacimiento;

		private String celular;

		private String dni;

		private String contraseña;
		private Rol rol;
		private Distrito distrito;
	}
	@Data
	public static class usuarioCreacionDTO{		
		
		private String nombre;

		private String apellidos;

		private Date fechanacimiento;

		private String celular;

		private String dni;

		private String contraseña;
		
		private Integer id_distrito;
	}

}

