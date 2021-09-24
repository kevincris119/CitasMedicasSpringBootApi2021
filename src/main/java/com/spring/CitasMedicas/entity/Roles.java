package com.spring.CitasMedicas.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
@Entity
@Table(name="roles")
public class Roles {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_roles;
	
	@Column(name = "nombre_rol",nullable=false,length = 100)
	private String nombre_rol;
	
}
