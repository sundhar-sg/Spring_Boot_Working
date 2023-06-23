package com.example.SampleRESTAppCD.security;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

	// Add support for JDBC and no more hard coded users
	
	@Bean
	public UserDetailsManager userDetailsManager(DataSource dataSource) {
		
		JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
		jdbcUserDetailsManager.setUsersByUsernameQuery("SELECT userID, password, active FROM members WHERE userID = ?");
		jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("SELECT userID, role FROM roles WHERE userID = ?");
		return jdbcUserDetailsManager;
	}
	
	@Bean
	public SecurityFilterChain customFilterChain(HttpSecurity http) throws Exception {
		
		http.authorizeHttpRequests( configurer ->
			configurer.requestMatchers(HttpMethod.GET, "/api/employees").hasRole("EMPLOYEE")
					.requestMatchers(HttpMethod.GET, "/api/employees/**").hasRole("EMPLOYEE")
					.requestMatchers(HttpMethod.POST, "/api/employees").hasRole("MANAGER")
					.requestMatchers(HttpMethod.PUT, "/api/employees").hasRole("MANAGER")
					.requestMatchers(HttpMethod.DELETE, "/api/employees/**").hasRole("ADMIN")
	
		);
		
		http.httpBasic(Customizer.withDefaults());
		
		http.csrf(csrf -> csrf.disable());
		
		return http.build();
	}
	
//	@Bean
//	public InMemoryUserDetailsManager userDetailsManager() {
//		
//		UserDetails sundhar = User.builder()
//				.username("sundhar_sg")
//				.password("{noop}Sundhar461@")
//				.roles("EMPLOYEE")
//				.build();
//		
//		UserDetails kishore = User.builder()
//				.username("kishore_k")
//				.password("{noop}Kishore123@")
//				.roles("EMPLOYEE", "MANAGER")
//				.build();
//		
//		UserDetails siddharrth = User.builder()
//				.username("siddharrth_gm")
//				.password("{noop}SiddhuMahi01@")
//				.roles("EMPLOYEE", "MANAGER", "ADMIN")
//				.build();
//		
//		return new InMemoryUserDetailsManager(sundhar, kishore, siddharrth);
//	}
}