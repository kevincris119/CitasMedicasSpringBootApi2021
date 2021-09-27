package com.spring.CitasMedicas.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Departamento {

	@Id
	@Column(nullable = false, length = 2)
	private String id_departamento;

	@Column(nullable = false, length = 45)
	private String nombre_departamento;
}
