package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	//for Authentication
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
		    .withUser("user1")
		    .password("password1")
		    .roles("ADMIN")
		    .and()
		    .withUser("user2")
		    .password("password2")
		    .roles("USER");
	}
	
	//for Authorization
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		    .antMatchers("/emp/*").hasRole("ADMIN")
		    .antMatchers("/emp/getAllEmp").hasAnyRole("USER","ADMIN")
		    .antMatchers("/product/*").hasAnyRole("USER","ADMIN")
		    .antMatchers("/").permitAll()
		    .antMatchers("/console/**").permitAll()
		    .and()
		    .formLogin();
		
		http.csrf().disable();
        http.headers().frameOptions().disable();

		
	}

	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();

	}
}
