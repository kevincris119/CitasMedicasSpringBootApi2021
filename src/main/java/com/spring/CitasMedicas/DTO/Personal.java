package com.spring.CitasMedicas.DTO;

import java.sql.Date;

import com.spring.CitasMedicas.Entity.Area;
import com.spring.CitasMedicas.Entity.Usuario;

import lombok.Data;

@Data
public class Personal {
	@Data
	public static class personalDTO {
		private Integer id_personal;
		private String nombre_area;
		private String categoria;
		private Usuario id_usuario;
		private Area id_area;
	}

	@Data
	public static class personalCreacionDTO {

		private Date fecha_registro;
		private String categoria;
		private Integer id_usuario;
		private Integer id_area;
	}
}
