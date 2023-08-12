package com.example.prueba.Entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;



@Entity
@Table(name="Pagos")
public class PagosEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer pagoID;
	@Column(name = "monto", precision = 6, scale = 2)
    private BigDecimal monto;
	
	@Column(name = "fecha_pago")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime fechaPago;

    @PrePersist
    public void prePersist() {
        fechaPago = LocalDateTime.now();
    }
    @Column(nullable = false)
    private boolean estado = true;
    @OneToOne
    @JoinColumn(name = "reservacionID", referencedColumnName = "reservacionID")
    private ReservacionEntity reservacion;
    

	public PagosEntity() {
		super();
	}

	public PagosEntity(Integer pagoID, BigDecimal monto, LocalDateTime fechaPago, boolean estado,
			ReservacionEntity reservacion) {
		super();
		this.pagoID = pagoID;
		this.monto = monto;
		this.fechaPago = fechaPago;
		this.estado = estado;
		this.reservacion = reservacion;
	}

	public Integer getPagoID() {
		return pagoID;
	}

	public void setPagoID(Integer pagoID) {
		this.pagoID = pagoID;
	}

	public BigDecimal getMonto() {
		return monto;
	}

	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}

	public LocalDateTime getFechaPago() {
		return fechaPago;
	}

	public void setFechaPago(LocalDateTime fechaPago) {
		this.fechaPago = fechaPago;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public ReservacionEntity getReservacion() {
		return reservacion;
	}

	public void setReservacion(ReservacionEntity reservacion) {
		this.reservacion = reservacion;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    

}
