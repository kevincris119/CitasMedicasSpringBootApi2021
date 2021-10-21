package com.spring.CitasMedicas.Entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Cita {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_cita;

	@Column(nullable = false)
	private Date fecha_registro;

	@Column(nullable = false)
	private String comentario;

	@Column(nullable = false)
	private Date fecha_cita;

	@ManyToOne
	@JoinColumn(name = "id_sede", nullable = false)
	private Sede sede;
	@ManyToOne
	@JoinColumn(name = "id_paciente", nullable = false)
	private Paciente paciente;

	@ManyToOne
	@JoinColumn(name = "id_area", nullable = false)
	private Area area;

	@ManyToOne
	@JoinColumn(name = "id_hora", nullable = false)
	private Hora hora;
}
