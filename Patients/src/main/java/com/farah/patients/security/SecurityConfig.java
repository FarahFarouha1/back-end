package com.farah.patients.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@Configuration
public class SecurityConfig {
	 
	@Autowired
	private DataSource dataSource;
 
	@Autowired
	UserDetailsService userDetailsService;
	
	 protected void configure(HttpSecurity http) throws Exception {
	 http.authorizeRequests().antMatchers("/showCreate").hasAnyRole("ADMIN","AGENT");
	 http.authorizeRequests().antMatchers("/saveProduit").hasAnyRole("ADMIN","AGENT");
	 http.authorizeRequests().antMatchers("/ListeProduits")
	 
	 .hasAnyRole("ADMIN","AGENT","USER");
	 
	 http.authorizeRequests()
	 .antMatchers("/supprimerProduit","/modifierProduit","/updateProduit")
	 .hasAnyRole("ADMIN");
	 
	 http.authorizeRequests().antMatchers("/login").permitAll();
	//pour faire fonctionner Bootstrap
	 http.authorizeRequests().antMatchers("/webjars/**").permitAll();
	 http.authorizeRequests().anyRequest().authenticated();
	
	 
	 http.formLogin().loginPage("/login");
	 http.exceptionHandling().accessDeniedPage("/accessDenied");
	 }

	 void configure(AuthenticationManagerBuilder auth) throws Exception {
		 
		 
			
		
	////////
//		 auth.jdbcAuthentication()
//		 .dataSource(dataSource)
//		 .usersByUsernameQuery("select username , password , enabled from user where username =?")
//		 .authoritiesByUsernameQuery(
//				 "SELECT u.username, r.role " +
//				 "FROM user_role ur, user u , role r " +
//				 "WHERE u.user_id = ur.user_id AND ur.role_id = r.role_id AND u.username = ?") 
//				 .passwordEncoder(passwordEncoder())
//				 .rolePrefix("ROLE_");
//		
		 PasswordEncoder passwordEncoder = passwordEncoder ();
		 auth.userDetailsService(userDetailsService)
		 .passwordEncoder(passwordEncoder);


	 }
	
	}