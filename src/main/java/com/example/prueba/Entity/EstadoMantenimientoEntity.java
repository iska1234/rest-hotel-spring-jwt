package com.example.prueba.Entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="EstadoMantenimiento")
public class EstadoMantenimientoEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	@Column(name = "estado_mantenimiento")
	private String estadoMantenimiento;
	@Column(name = "descripcion")
	private String descripcionMantenimiento;
	@Column(nullable = false)
    private boolean estado = true;
	public EstadoMantenimientoEntity() {
		super();
	}
	public EstadoMantenimientoEntity(Integer id, String estadoMantenimiento, String descripcionMantenimiento,
			boolean estado) {
		super();
		this.id = id;
		this.estadoMantenimiento = estadoMantenimiento;
		this.descripcionMantenimiento = descripcionMantenimiento;
		this.estado = estado;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEstadoMantenimiento() {
		return estadoMantenimiento;
	}
	public void setEstadoMantenimiento(String estadoMantenimiento) {
		this.estadoMantenimiento = estadoMantenimiento;
	}
	public String getDescripcionMantenimiento() {
		return descripcionMantenimiento;
	}
	public void setDescripcionMantenimiento(String descripcionMantenimiento) {
		this.descripcionMantenimiento = descripcionMantenimiento;
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
