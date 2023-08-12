package com.example.prueba.Entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;





@Entity
@Table(name="Habitacion")
public class HabitacionEntity  implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer habitacionID;
	@Column(name = "codigo", length = 5)
	private String codigo;
	@Column
	private String descripcion;
	@Column
	private Integer capacidad;
	@Column(name = "monto", precision = 6, scale = 2)
    private BigDecimal tarifa;
	@OneToOne
    @JoinColumn(name = "tipo_habitacion_id")
    private TipoHabitacionEntity tipoHabitacion;
	@OneToMany(mappedBy = "habitacion")
	private List<ReservacionHabitacionEntity> reservacionHabitaciones;
	@OneToOne
	@JoinColumn(name = "estado_habitacion_id")
	private EstadoHabitacionEntity estadoHabitacion;
	
	public HabitacionEntity() {
		super();
	}
	public HabitacionEntity(Integer habitacionID, String codigo, String descripcion, Integer capacidad,
			BigDecimal tarifa, TipoHabitacionEntity tipoHabitacion,
			List<ReservacionHabitacionEntity> reservacionHabitaciones, EstadoHabitacionEntity estadoHabitacion) {
		super();
		this.habitacionID = habitacionID;
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.capacidad = capacidad;
		this.tarifa = tarifa;
		this.tipoHabitacion = tipoHabitacion;
		this.reservacionHabitaciones = reservacionHabitaciones;
		this.estadoHabitacion = estadoHabitacion;
	}
	public Integer getHabitacionID() {
		return habitacionID;
	}
	public void setHabitacionID(Integer habitacionID) {
		this.habitacionID = habitacionID;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Integer getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(Integer capacidad) {
		this.capacidad = capacidad;
	}
	public BigDecimal getTarifa() {
		return tarifa;
	}
	public void setTarifa(BigDecimal tarifa) {
		this.tarifa = tarifa;
	}
	public TipoHabitacionEntity getTipoHabitacion() {
		return tipoHabitacion;
	}
	public void setTipoHabitacion(TipoHabitacionEntity tipoHabitacion) {
		this.tipoHabitacion = tipoHabitacion;
	}
	public List<ReservacionHabitacionEntity> getReservacionHabitaciones() {
		return reservacionHabitaciones;
	}
	public void setReservacionHabitaciones(List<ReservacionHabitacionEntity> reservacionHabitaciones) {
		this.reservacionHabitaciones = reservacionHabitaciones;
	}
	public EstadoHabitacionEntity getEstadoHabitacion() {
		return estadoHabitacion;
	}
	public void setEstadoHabitacion(EstadoHabitacionEntity estadoHabitacion) {
		this.estadoHabitacion = estadoHabitacion;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}
