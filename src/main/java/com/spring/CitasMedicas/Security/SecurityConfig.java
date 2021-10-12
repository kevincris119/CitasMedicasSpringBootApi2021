package com.spring.CitasMedicas.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.spring.CitasMedicas.Service.UsuarioService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	
	@Autowired
	UsuarioService userService;

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder;
	}
	
	@Bean
	public DaoAuthenticationProvider authProvider() {
		DaoAuthenticationProvider authProvider=new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userService);
		authProvider.setPasswordEncoder(passwordEncoder());
		return authProvider;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
		
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	        http
	        		.csrf().disable()
	        		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
	                .authorizeRequests()
	                .antMatchers("/v2/api-docs", "/swagger-resources/configuration/ui", "/swagger-resources", "/swagger-resources/configuration/security", "/swagger-ui.html", "/webjars/**").permitAll()
	                .antMatchers("/api/usuario").permitAll()
	                .antMatchers("/swagger-ui/").permitAll()
	                .antMatchers(HttpMethod.POST,"/users").permitAll()
	                .antMatchers(HttpMethod.POST,"/api/usuario").permitAll();
	                /*.anyRequest().authenticated().and()
	                .addFilter(new JWTAuthenticationFilter(authenticationManager()))
	                .addFilter(new JWTAuthorizationFilter(authenticationManager()));*/
	}
	
	
	

}
