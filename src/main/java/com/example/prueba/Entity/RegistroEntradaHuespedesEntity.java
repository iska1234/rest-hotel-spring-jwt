package com.example.prueba.Entity;

import java.io.Serializable;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name = "Registro_Entrada_Huespedes")
public class RegistroEntradaHuespedesEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idRegistroEntradaHuesped;
	@ManyToOne
	@JoinColumn(name = "idPersonal")
	private PersonalEntity personal;
	    
	@ManyToOne
	@JoinColumn(name = "idReservacion")
	private ReservacionEntity reservacion;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime fechaEntradaHuesped;
	@ManyToMany
	@JoinTable(name = "Huesped_Registro_Entrada",
			joinColumns = @JoinColumn(name = "id_registro_entrada_huesped"),
			inverseJoinColumns = @JoinColumn(name = "id_huesped"))
	private List<HuespedEntity> huespedes = new ArrayList<>();
	
	@PrePersist
	public void prePersist() {
		fechaEntradaHuesped=LocalDateTime.now();
	}
	

	public RegistroEntradaHuespedesEntity() {
		super();
	}


	public RegistroEntradaHuespedesEntity(Integer idRegistroEntradaHuesped, PersonalEntity personal,
			ReservacionEntity reservacion, LocalDateTime fechaEntradaHuesped, List<HuespedEntity> huespedes) {
		super();
		this.idRegistroEntradaHuesped = idRegistroEntradaHuesped;
		this.personal = personal;
		this.reservacion = reservacion;
		this.fechaEntradaHuesped = fechaEntradaHuesped;
		this.huespedes = huespedes;
	}

	public Integer getIdRegistroEntradaHuesped() {
		return idRegistroEntradaHuesped;
	}

	public void setIdRegistroEntradaHuesped(Integer idRegistroEntradaHuesped) {
		this.idRegistroEntradaHuesped = idRegistroEntradaHuesped;
	}

	public PersonalEntity getPersonal() {
		return personal;
	}

	public void setPersonal(PersonalEntity personal) {
		this.personal = personal;
	}

	public ReservacionEntity getReservacion() {
		return reservacion;
	}

	public void setReservacion(ReservacionEntity reservacion) {
		this.reservacion = reservacion;
	}

	public LocalDateTime getFechaEntradaHuesped() {
		return fechaEntradaHuesped;
	}

	public void setFechaEntradaHuesped(LocalDateTime fechaEntradaHuesped) {
		this.fechaEntradaHuesped = fechaEntradaHuesped;
	}

	public List<HuespedEntity> getHuespedes() {
		return huespedes;
	}

	public void setHuespedes(List<HuespedEntity> huespedes) {
		this.huespedes = huespedes;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}
