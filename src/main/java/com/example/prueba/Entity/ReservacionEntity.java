package com.example.prueba.Entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;




@Entity
@Table(name="Reservacion")
public class ReservacionEntity  implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer reservacionID;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime fechaCreacionReservacion;
	@Column(nullable = false)
    private boolean estado = true;
	@Column(name = "monto", precision = 6, scale = 2)
    private BigDecimal monto;
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private ClienteEntity cliente;
	@OneToMany(mappedBy = "reservacion")
	private List<ReservacionHabitacionEntity> reservacionHabitaciones;
	@OneToOne(mappedBy = "reservacion")
	private PagosEntity pago;
	@PrePersist
    public void prePersist() {
		fechaCreacionReservacion = LocalDateTime.now();
    }
	
	public ReservacionEntity() {
		super();
	}

	public ReservacionEntity(Integer reservacionID, LocalDateTime fechaCreacionReservacion, boolean estado,
			BigDecimal monto, ClienteEntity cliente, List<ReservacionHabitacionEntity> reservacionHabitaciones,
			PagosEntity pago) {
		super();
		this.reservacionID = reservacionID;
		this.fechaCreacionReservacion = fechaCreacionReservacion;
		this.estado = estado;
		this.monto = monto;
		this.cliente = cliente;
		this.reservacionHabitaciones = reservacionHabitaciones;
		this.pago = pago;
	}
	public Integer getReservacionID() {
		return reservacionID;
	}
	public void setReservacionID(Integer reservacionID) {
		this.reservacionID = reservacionID;
	}
	public LocalDateTime getFechaCreacionReservacion() {
		return fechaCreacionReservacion;
	}
	public void setFechaCreacionReservacion(LocalDateTime fechaCreacionReservacion) {
		this.fechaCreacionReservacion = fechaCreacionReservacion;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	public BigDecimal getMonto() {
		return monto;
	}
	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}
	public ClienteEntity getCliente() {
		return cliente;
	}
	public void setCliente(ClienteEntity cliente) {
		this.cliente = cliente;
	}
	public List<ReservacionHabitacionEntity> getReservacionHabitaciones() {
		return reservacionHabitaciones;
	}
	public void setReservacionHabitaciones(List<ReservacionHabitacionEntity> reservacionHabitaciones) {
		this.reservacionHabitaciones = reservacionHabitaciones;
	}
	public PagosEntity getPago() {
		return pago;
	}
	public void setPago(PagosEntity pago) {
		this.pago = pago;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}
