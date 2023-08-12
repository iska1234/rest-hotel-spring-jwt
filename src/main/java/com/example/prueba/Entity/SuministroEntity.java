package com.example.prueba.Entity;

import java.io.Serializable;
import java.time.LocalDateTime;
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


@Entity
@Table(name="Suministros")
public class SuministroEntity implements Serializable{
private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer suministroID;
	
	@Column
	private String nombre;
	
	@Column
	private String descripcion;
	
	@Column
	private String unidadDeMedida;
	
	@Column
	private Integer stock;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime fechaRegistroSuministro;
	@ManyToMany(mappedBy = "suministros")
    private List<ProveedoresEntity> proveedores = new ArrayList<>();
	
	@PrePersist
	public void prePersist() {
		fechaRegistroSuministro=LocalDateTime.now();
	}
	

	public SuministroEntity() {
		super();
	}


	public SuministroEntity(Integer suministroID, String nombre, String descripcion, String unidadDeMedida,
			Integer stock, LocalDateTime fechaRegistroSuministro, List<ProveedoresEntity> proveedores) {
		super();
		this.suministroID = suministroID;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.unidadDeMedida = unidadDeMedida;
		this.stock = stock;
		this.fechaRegistroSuministro = fechaRegistroSuministro;
		this.proveedores = proveedores;
	}

	public Integer getSuministroID() {
		return suministroID;
	}

	public void setSuministroID(Integer suministroID) {
		this.suministroID = suministroID;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getUnidadDeMedida() {
		return unidadDeMedida;
	}

	public void setUnidadDeMedida(String unidadDeMedida) {
		this.unidadDeMedida = unidadDeMedida;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public LocalDateTime getFechaRegistroSuministro() {
		return fechaRegistroSuministro;
	}

	public void setFechaRegistroSuministro(LocalDateTime fechaRegistroSuministro) {
		this.fechaRegistroSuministro = fechaRegistroSuministro;
	}

	public List<ProveedoresEntity> getProveedores() {
		return proveedores;
	}

	public void setProveedores(List<ProveedoresEntity> proveedores) {
		this.proveedores = proveedores;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
