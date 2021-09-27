package com.spring.CitasMedicas.Entity;

import javax.persistence.CascadeType;
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
public class Administrador {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_administrador;

	@Column(nullable = false, length = 100)
	private String cargo;

	@ManyToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "id_usuario", nullable = false)
	private Usuario usuario;
}
