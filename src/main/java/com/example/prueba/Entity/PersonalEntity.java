package com.example.prueba.Entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;



@Entity
@Table(name="Personal")
public class PersonalEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer personalID;
	@Column(name = "codigo", length = 5)
	private String codigo;
	@Column
	private String nombres;
	@Column
	private String apellidos;
	@Column
	private String descripcion;
	@DateTimeFormat(pattern="yyyy-MM-dd",iso=ISO.DATE)
	private LocalDate fechaInicioActividades;
	@OneToOne
	@JoinColumn(name = "user_id")
	private UserEntity usuario;
	@OneToOne(mappedBy = "personal")
    private PlanillaTrabajadorEntity planillaTrabajador;
	@Column(nullable = false)
    private boolean estado = true;
	
	public PersonalEntity() {
		super();
	}

	public PersonalEntity(Integer personalID, String codigo, String nombres, String apellidos, String descripcion,
			LocalDate fechaInicioActividades, UserEntity usuario, PlanillaTrabajadorEntity planillaTrabajador,
			boolean estado) {
		super();
		this.personalID = personalID;
		this.codigo = codigo;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.descripcion = descripcion;
		this.fechaInicioActividades = fechaInicioActividades;
		this.usuario = usuario;
		this.planillaTrabajador = planillaTrabajador;
		this.estado = estado;
	}

	public Integer getPersonalID() {
		return personalID;
	}

	public void setPersonalID(Integer personalID) {
		this.personalID = personalID;
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

	public LocalDate getFechaInicioActividades() {
		return fechaInicioActividades;
	}

	public void setFechaInicioActividades(LocalDate fechaInicioActividades) {
		this.fechaInicioActividades = fechaInicioActividades;
	}

	public UserEntity getUsuario() {
		return usuario;
	}

	public void setUsuario(UserEntity usuario) {
		this.usuario = usuario;
	}

	public PlanillaTrabajadorEntity getPlanillaTrabajador() {
		return planillaTrabajador;
	}

	public void setPlanillaTrabajador(PlanillaTrabajadorEntity planillaTrabajador) {
		this.planillaTrabajador = planillaTrabajador;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
