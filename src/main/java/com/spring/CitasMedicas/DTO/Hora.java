package com.spring.CitasMedicas.DTO;

import lombok.Data;

@Data
public class Hora {
	@Data
	public static class HoraDTO {
		private Integer id_hora;

		private String rango_horas;

		private boolean estado;
	}

	@Data
	public static class HoraCreacionDTO {
		private String rango_horas;

		private boolean estado;
	}
}
