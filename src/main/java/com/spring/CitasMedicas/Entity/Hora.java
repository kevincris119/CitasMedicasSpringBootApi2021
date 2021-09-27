package com.spring.CitasMedicas.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Hora {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_hora;

	@Column(nullable = false, length = 100)
	private String rango_horas;

	@Column(nullable = false, length = 1)
	private boolean estado;
}
