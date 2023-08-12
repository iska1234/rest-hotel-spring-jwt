package com.example.prueba.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;



@Entity
@Table(name="EstadoHabitacion")
public class EstadoHabitacionEntity {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer estadoID;
	@Column
	private String tipo;
	@Column
	private String descripcion;
	@Column(nullable = false)
    private boolean estado = true;
	public EstadoHabitacionEntity() {
		super();
	}
	public EstadoHabitacionEntity(Integer estadoID, String tipo, String descripcion, boolean estado) {
		super();
		this.estadoID = estadoID;
		this.tipo = tipo;
		this.descripcion = descripcion;
		this.estado = estado;
	}
	public Integer getEstadoID() {
		return estadoID;
	}
	public void setEstadoID(Integer estadoID) {
		this.estadoID = estadoID;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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
