package com.spring.CitasMedicas.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
public class Provincia {
	@Id
	@Column(nullable = false, length = 4)
	private Integer id_provincia;

	@Column(nullable = false, length = 45)
	private String nombre_provincia;

	@ManyToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "id_departamento", nullable = false)
	private Departamento departamento;
}
