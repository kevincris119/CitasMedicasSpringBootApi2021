package com.spring.CitasMedicas.DTO;

import java.sql.Date;

import com.spring.CitasMedicas.Entity.Area;
import com.spring.CitasMedicas.Entity.Hora;
import com.spring.CitasMedicas.Entity.Paciente;
import com.spring.CitasMedicas.Entity.Sede;

import lombok.Data;

@Data
public class Cita {
	@Data
	public static class CitaDTO {

		private Integer id_cita;
		private Date fecha_registro;
		private String comentario;
		private Date fecha_cita;
		private Sede sede;
		private Paciente paciente;
		private Area area;
		private Hora hora;
	}

	@Data
	public static class CitaCreacionDTO {

		private Date fecha_registro;
		private String comentario;
		private Date fecha_cita;
		private Integer id_sede;
		private Integer id_paciente;
		private Integer id_area;
		private Integer id_hora;
	}
}
