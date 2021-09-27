package com.spring.CitasMedicas.DTO;

import java.sql.Date;

import lombok.Data;

@Data
public class UsuarioDTO {

	private String nombre;

	private String apellidos;

	private Date fechanacimiento;

	private String celular;

	private String dni;

	private String contraseña;
	private Integer id_rol;
	private Integer id_distrito;

}
