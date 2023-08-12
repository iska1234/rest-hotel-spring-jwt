package com.example.prueba.Entity;

import java.io.Serializable;
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
@Table(name="Clientes")
public class ClienteEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer clienteID;
	@Column
	private String nombres;
	@Column
	private String apellidos;
	@Column(name = "dni", length = 8)
	private String dni;
	@Column(name = "telefono", length = 9)
	private String telefono;
	@OneToOne
	@JoinColumn(name = "user_id")
	private UserEntity usuario;
	@OneToMany(mappedBy = "cliente")
	private List<ReservacionEntity> reservaciones;
	
	
	
	public ClienteEntity() {
		super();
	}
	public ClienteEntity(Integer clienteID, String nombres, String apellidos, String dni, String telefono,
			UserEntity usuario, List<ReservacionEntity> reservaciones) {
		super();
		this.clienteID = clienteID;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.dni = dni;
		this.telefono = telefono;
		this.usuario = usuario;
		this.reservaciones = reservaciones;
	}
	public Integer getClienteID() {
		return clienteID;
	}
	public void setClienteID(Integer clienteID) {
		this.clienteID = clienteID;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public UserEntity getUsuario() {
		return usuario;
	}
	public void setUsuario(UserEntity usuario) {
		this.usuario = usuario;
	}
	public List<ReservacionEntity> getReservaciones() {
		return reservaciones;
	}
	public void setReservaciones(List<ReservacionEntity> reservaciones) {
		this.reservaciones = reservaciones;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}
