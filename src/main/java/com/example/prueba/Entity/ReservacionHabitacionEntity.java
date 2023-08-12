package com.example.prueba.Entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;



@Entity
@Table(name = "Reservacion_Habitacion")
public class ReservacionHabitacionEntity implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@EmbeddedId
    private reservacionHabitacionID id;

    @ManyToOne
    @MapsId("reservacionID")
    @JoinColumn(name = "reservacion_id")
    private ReservacionEntity reservacion;

    @ManyToOne
    @MapsId("habitacionID")
    @JoinColumn(name = "habitacion_id")
    private HabitacionEntity habitacion;
    @DateTimeFormat(pattern="yyyy-MM-dd",iso=ISO.DATE)
	private LocalDate fechaInicioReservacion;
    @DateTimeFormat(pattern="yyyy-MM-dd",iso=ISO.DATE)
	private LocalDate fechaFinReservacion;
    @Column(name = "monto", precision = 6, scale = 2)
    private BigDecimal monto;
    
    public ReservacionHabitacionEntity() {
		super();
	}


	public ReservacionHabitacionEntity(reservacionHabitacionID id, ReservacionEntity reservacion,
			HabitacionEntity habitacion, LocalDate fechaInicioReservacion, LocalDate fechaFinReservacion,
			BigDecimal monto) {
		super();
		this.id = id;
		this.reservacion = reservacion;
		this.habitacion = habitacion;
		this.fechaInicioReservacion = fechaInicioReservacion;
		this.fechaFinReservacion = fechaFinReservacion;
		this.monto = monto;
	}
    

	public reservacionHabitacionID getId() {
		return id;
	}


	public void setId(reservacionHabitacionID id) {
		this.id = id;
	}


	public ReservacionEntity getReservacion() {
		return reservacion;
	}


	public void setReservacion(ReservacionEntity reservacion) {
		this.reservacion = reservacion;
	}


	public HabitacionEntity getHabitacion() {
		return habitacion;
	}


	public void setHabitacion(HabitacionEntity habitacion) {
		this.habitacion = habitacion;
	}


	public LocalDate getFechaInicioReservacion() {
		return fechaInicioReservacion;
	}


	public void setFechaInicioReservacion(LocalDate fechaInicioReservacion) {
		this.fechaInicioReservacion = fechaInicioReservacion;
	}


	public LocalDate getFechaFinReservacion() {
		return fechaFinReservacion;
	}


	public void setFechaFinReservacion(LocalDate fechaFinReservacion) {
		this.fechaFinReservacion = fechaFinReservacion;
	}


	public BigDecimal getMonto() {
		return monto;
	}


	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Embeddable
    public static class reservacionHabitacionID implements Serializable {
        private static final long serialVersionUID = 1L;

        private Integer reservacionID;

        private Integer habitacionID;

		public reservacionHabitacionID(Integer reservacionID, Integer habitacionID) {
			super();
			this.reservacionID = reservacionID;
			this.habitacionID = habitacionID;
		}

		public Integer getReservacionID() {
			return reservacionID;
		}

		public void setReservacionID(Integer reservacionID) {
			this.reservacionID = reservacionID;
		}

		public Integer getHabitacionID() {
			return habitacionID;
		}

		public void setHabitacionID(Integer habitacionID) {
			this.habitacionID = habitacionID;
		}

		public static long getSerialversionuid() {
			return serialVersionUID;
		}
        
        }

}
