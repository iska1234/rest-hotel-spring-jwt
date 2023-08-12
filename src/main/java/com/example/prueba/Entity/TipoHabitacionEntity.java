package com.example.prueba.Entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TipoHabitacion")
public class TipoHabitacionEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer tipeID;
	@Column
	private String tipo;
	@Column
	private Double costo;
	
	public TipoHabitacionEntity() {
		super();
	}
	
	public TipoHabitacionEntity(Integer tipeID, String tipo, Double costo) {
		super();
		this.tipeID = tipeID;
		this.tipo = tipo;
		this.costo = costo;
	}

	public Integer getTipeID() {
		return tipeID;
	}
	public void setTipeID(Integer tipeID) {
		this.tipeID = tipeID;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Double getCosto() {
		return costo;
	}

	public void setCosto(Double costo) {
		this.costo = costo;
	}
	
	
	
}
