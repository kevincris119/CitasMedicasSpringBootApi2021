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
public class Distrito {
	@Id
	@Column(nullable = false, length = 6)
	private Integer id_distrito;

	@Column(nullable = false, length = 45)
	private String nombre_distrito;

	@ManyToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "id_provincia", nullable = false)
	private Provincia provincia;

	@Column(nullable = false, length = 2)
	private String cod_departamento;
}
