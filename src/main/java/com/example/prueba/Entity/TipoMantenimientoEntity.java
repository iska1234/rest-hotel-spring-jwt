package com.example.prueba.Entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TipoMantenimiento")
public class TipoMantenimientoEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	@Column(name = "tipo")
	private String tipoMantenimiento;
	@Column(name = "descripcion")
	private String descripcionMantenimiento;
	
	public TipoMantenimientoEntity() {
		super();
	}
	public TipoMantenimientoEntity(Integer id, String tipoMantenimiento, String descripcionMantenimiento) {
		super();
		this.id = id;
		this.tipoMantenimiento = tipoMantenimiento;
		this.descripcionMantenimiento = descripcionMantenimiento;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTipoMantenimiento() {
		return tipoMantenimiento;
	}
	public void setTipoMantenimiento(String tipoMantenimiento) {
		this.tipoMantenimiento = tipoMantenimiento;
	}
	public String getDescripcionMantenimiento() {
		return descripcionMantenimiento;
	}
	public void setDescripcionMantenimiento(String descripcionMantenimiento) {
		this.descripcionMantenimiento = descripcionMantenimiento;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}
