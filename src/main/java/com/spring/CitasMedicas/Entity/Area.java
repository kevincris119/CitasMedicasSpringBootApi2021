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
public class Area {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_area;

	@Column(nullable = false, length = 100)
	private String nombre_area;
}
