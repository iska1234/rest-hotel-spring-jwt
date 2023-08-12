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
@Table(name = "Registro_Salida_Huespedes")
public class RegistroSalidaHuespedesEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idRegistroSalidaHuesped;
	@ManyToOne
	@JoinColumn(name = "idPersonal")
	private PersonalEntity personal;
	    
	@ManyToOne
	@JoinColumn(name = "idReservacion")
	private ReservacionEntity reservacion;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime fechaSalidaHuesped;
	@ManyToMany
	@JoinTable(name = "Huesped_Registro_Salida",
			joinColumns = @JoinColumn(name = "id_registro_entrada_huesped"),
			inverseJoinColumns = @JoinColumn(name = "id_huesped"))
	private List<HuespedEntity> huespedes = new ArrayList<>();
	
	@PrePersist
	public void prePersist() {
		fechaSalidaHuesped=LocalDateTime.now();
	}
	

	public RegistroSalidaHuespedesEntity() {
		super();
	}


	public RegistroSalidaHuespedesEntity(Integer idRegistroSalidaHuesped, PersonalEntity personal,
			ReservacionEntity reservacion, LocalDateTime fechaSalidaHuesped, List<HuespedEntity> huespedes) {
		super();
		this.idRegistroSalidaHuesped = idRegistroSalidaHuesped;
		this.personal = personal;
		this.reservacion = reservacion;
		this.fechaSalidaHuesped = fechaSalidaHuesped;
		this.huespedes = huespedes;
	}

	public Integer getIdRegistroSalidaHuesped() {
		return idRegistroSalidaHuesped;
	}

	public void setIdRegistroSalidaHuesped(Integer idRegistroSalidaHuesped) {
		this.idRegistroSalidaHuesped = idRegistroSalidaHuesped;
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

	public LocalDateTime getFechaSalidaHuesped() {
		return fechaSalidaHuesped;
	}

	public void setFechaSalidaHuesped(LocalDateTime fechaSalidaHuesped) {
		this.fechaSalidaHuesped = fechaSalidaHuesped;
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
