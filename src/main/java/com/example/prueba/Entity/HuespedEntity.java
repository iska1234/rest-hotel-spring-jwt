package com.example.prueba.Entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
@Entity
@Table(name="Huesped")
public class HuespedEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer huespedID;
	@Column(name = "nombres_huesped")
	private String nombres;
	@Column(name = "apellidos_huesped")
	private String apellidos;
	@Column(name = "dni_huesped")
	private String dni;
	@DateTimeFormat(pattern="yyyy-MM-dd",iso=ISO.DATE)
	private LocalDate fechaCreacionHuesped;
	@Column(nullable = false)
    private boolean estado = true;
	@ManyToMany(mappedBy = "huespedes")
	private List<RegistroEntradaHuespedesEntity> registrosEntrada = new ArrayList<>();
	@PrePersist
	public void prePersist() {
		fechaCreacionHuesped=LocalDate.now();
	}
	
	public HuespedEntity() {
		super();
	}

	public HuespedEntity(Integer huespedID, String nombres, String apellidos, String dni,
			LocalDate fechaCreacionHuesped, boolean estado, List<RegistroEntradaHuespedesEntity> registrosEntrada) {
		super();
		this.huespedID = huespedID;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.dni = dni;
		this.fechaCreacionHuesped = fechaCreacionHuesped;
		this.estado = estado;
		this.registrosEntrada = registrosEntrada;
	}
	public Integer getHuespedID() {
		return huespedID;
	}
	public void setHuespedID(Integer huespedID) {
		this.huespedID = huespedID;
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
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public LocalDate getFechaCreacionHuesped() {
		return fechaCreacionHuesped;
	}
	public void setFechaCreacionHuesped(LocalDate fechaCreacionHuesped) {
		this.fechaCreacionHuesped = fechaCreacionHuesped;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	public List<RegistroEntradaHuespedesEntity> getRegistrosEntrada() {
		return registrosEntrada;
	}
	public void setRegistrosEntrada(List<RegistroEntradaHuespedesEntity> registrosEntrada) {
		this.registrosEntrada = registrosEntrada;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}
