package com.example.prueba.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.prueba.JWT.JWTRequestFilter;
import com.example.prueba.Model.JWT.JwtAuthenticationEntryPoint;
import com.example.prueba.Service.UserServiceImpl;



@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	@Autowired
	private UserServiceImpl userServiceImpl;
	@Autowired
    private JWTRequestFilter jwtRequestFilter;
	//PasswordEncoder
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	@Bean
	public JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint() {
	    return new JwtAuthenticationEntryPoint();
	}
	// AuthenticationManager
	@Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
	//Autenticación
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception 
	{	
		//en database
		auth.userDetailsService(userServiceImpl).passwordEncoder(passwordEncoder());;
	}
	//Autorización
	@Override
	protected void configure(HttpSecurity http) throws Exception 
	{
		http.authorizeRequests()
        .antMatchers("/User/RegistrarUsuarioCliente").permitAll()
        .antMatchers("/User/RegistrarUsuarioPersonal").permitAll()
        .antMatchers("/User/login").permitAll() //.hasRole("ADMIN")
        .antMatchers("/User/tokenInfo").permitAll()
        .antMatchers("/Huespedes/listar").hasRole("USER")
        .anyRequest().authenticated()
        .and()
        .sessionManagement()
        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .and()
        // Desactivar CSRF
        .csrf().disable()
        .addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class)
        .exceptionHandling()
        .authenticationEntryPoint(jwtAuthenticationEntryPoint())
        .and()
        .headers()
        .frameOptions()
        .sameOrigin();
	}

}
