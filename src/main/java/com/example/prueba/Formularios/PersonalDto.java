package com.example.prueba.Formularios;

import java.math.BigDecimal;

public class PersonalDto {
	private String email;
    private String password;
    private String codigo;
    private String nombres;
    private String apellidos;
    private String descripcion;
    private String tipoTrabajador;
    private BigDecimal monto;
	public PersonalDto(String email, String password, String codigo, String nombres, String apellidos,
			String descripcion, String tipoTrabajador, BigDecimal monto) {
		super();
		this.email = email;
		this.password = password;
		this.codigo = codigo;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.descripcion = descripcion;
		this.tipoTrabajador = tipoTrabajador;
		this.monto = monto;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getTipoTrabajador() {
		return tipoTrabajador;
	}
	public void setTipoTrabajador(String tipoTrabajador) {
		this.tipoTrabajador = tipoTrabajador;
	}
	public BigDecimal getMonto() {
		return monto;
	}
	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}
    
    
}
