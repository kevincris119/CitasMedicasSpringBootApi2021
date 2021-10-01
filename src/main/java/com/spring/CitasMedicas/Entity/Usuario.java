package com.spring.CitasMedicas.Entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Usuario implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_usuario;

	@Column(nullable = false, length = 100)
	private String nombre;

	@Column(nullable = false, length = 100)
	private String apellidos;

	@Column(nullable = false)
	private Date fechanacimiento;

	@Column(nullable = false, length = 9)
	private String celular;

	@Column(nullable = false, length = 8)
	private String dni;

	@Column(nullable = false)
	private String contraseña;

	@ManyToOne
	@JoinColumn(name = "id_rol", nullable = false)
	private Rol rol;

	@ManyToOne
	@JoinColumn(referencedColumnName = "id_distrito", name = "id_distrito", nullable = false)
	private Distrito distrito;

	@Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> roles = new ArrayList<>();
        roles.add(new SimpleGrantedAuthority(rol.getNombre_rol()));
        return roles;
    }

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return contraseña;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return dni;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
