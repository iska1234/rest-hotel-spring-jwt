package com.example.prueba.Entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIdentityReference;

@Entity
@Table(name="Mantenimiento")
public class MantenimientoEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer mantenimientoID;
	
	@ManyToOne
	@JoinColumn(name = "idPersonal")
	private PersonalEntity personal;
	
	@Column(name = "fecha_registro_mantenimiento")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime fechaRegistroMantenimiento;
	
	@Column
	private String descripcion;
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="mantenimiento_tipo",
		joinColumns=@JoinColumn(name="mantenimiento_id"),
		inverseJoinColumns=@JoinColumn(name="tipo_id"))
	@JsonIdentityReference(alwaysAsId = true)
	private Set<TipoMantenimientoEntity>itemsMantenimiento=new HashSet<>();
	@OneToOne
    @JoinColumn(name = "estado_mantenimiento_id")
    private EstadoMantenimientoEntity estadoMantenimiento;
	@Column(nullable = false)
    private boolean estado = true;
	
	@PrePersist
    public void prePersist() {
		fechaRegistroMantenimiento = LocalDateTime.now();
    }

	public MantenimientoEntity(Integer mantenimientoID, PersonalEntity personal,
			LocalDateTime fechaRegistroMantenimiento, String descripcion,
			Set<TipoMantenimientoEntity> itemsMantenimiento, EstadoMantenimientoEntity estadoMantenimiento,
			boolean estado) {
		super();
		this.mantenimientoID = mantenimientoID;
		this.personal = personal;
		this.fechaRegistroMantenimiento = fechaRegistroMantenimiento;
		this.descripcion = descripcion;
		this.itemsMantenimiento = itemsMantenimiento;
		this.estadoMantenimiento = estadoMantenimiento;
		this.estado = estado;
	}

	public Integer getMantenimientoID() {
		return mantenimientoID;
	}

	public void setMantenimientoID(Integer mantenimientoID) {
		this.mantenimientoID = mantenimientoID;
	}

	public PersonalEntity getPersonal() {
		return personal;
	}

	public void setPersonal(PersonalEntity personal) {
		this.personal = personal;
	}

	public LocalDateTime getFechaRegistroMantenimiento() {
		return fechaRegistroMantenimiento;
	}

	public void setFechaRegistroMantenimiento(LocalDateTime fechaRegistroMantenimiento) {
		this.fechaRegistroMantenimiento = fechaRegistroMantenimiento;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Set<TipoMantenimientoEntity> getItemsMantenimiento() {
		return itemsMantenimiento;
	}

	public void setItemsMantenimiento(Set<TipoMantenimientoEntity> itemsMantenimiento) {
		this.itemsMantenimiento = itemsMantenimiento;
	}

	public EstadoMantenimientoEntity getEstadoMantenimiento() {
		return estadoMantenimiento;
	}

	public void setEstadoMantenimiento(EstadoMantenimientoEntity estadoMantenimiento) {
		this.estadoMantenimiento = estadoMantenimiento;
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
