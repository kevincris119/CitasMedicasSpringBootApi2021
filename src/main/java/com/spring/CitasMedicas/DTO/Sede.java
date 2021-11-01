package com.spring.CitasMedicas.DTO;

import lombok.Data;

@Data
public class Sede {
	@Data
	public static class SedeDTO {
		private Integer id_sede;

		private String nombre_sede;
	}

	@Data
	public static class SedeCreacionDTO {
		private String nombre_sede;
	}
}
