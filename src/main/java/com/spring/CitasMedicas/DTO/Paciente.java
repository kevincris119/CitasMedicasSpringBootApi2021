package com.spring.CitasMedicas.DTO;

import com.spring.CitasMedicas.Entity.Usuario;

import lombok.Data;

@Data
public class Paciente {
	@Data
	public static class PacienteDTO {
		private Integer id_paciente;

		private String historia_clinica;

		private Usuario usuario;
	}

	@Data
	public static class PacienteCreacionDTO {
		private String historia_clinica;

		private Integer id_usuario;
	}
}
