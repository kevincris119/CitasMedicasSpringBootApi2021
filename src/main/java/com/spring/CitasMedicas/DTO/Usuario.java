package com.spring.CitasMedicas.DTO;

import java.sql.Date;

import com.spring.CitasMedicas.Entity.Distrito;
import com.spring.CitasMedicas.Entity.Rol;

import lombok.Data;

public class Usuario {
	@Data
	public static class usuarioDTO {

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
	public static class usuarioCreacionDTO {

		private String nombre;

		private String apellidos;

		private Date fechanacimiento;

		private String celular;

		private String dni;

		private String contraseña;

		private Integer id_distrito;
	}
	@Data
	public static class RespuestaLoginDTO {

		private String nombre;

		private String apellido;

		private String dni;

		private String nombre_rol;
		
		private Integer Id_Paciente;
	}
	public interface loginDTO { 
		
		String getNombre();
		
		String getApellido();

		String getDni();

		String getNombre_rol();
		
		String getContraseña();
		
		Integer getId_Paciente();
	}
	

	@Data
	public static class loginCreacionDTO {
		private String dni;
		private String contraseña;
	}

}
