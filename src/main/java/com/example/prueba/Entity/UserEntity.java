package com.example.prueba.Entity;

import java.io.Serializable;
import java.time.LocalDate;
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
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonIdentityReference;



@Entity
@Table(name="users")
public class UserEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer usuarioID;
	
	@Column
	private String email;
	
	@Column
	private String password;
	
	@DateTimeFormat(pattern="yyyy-MM-dd",iso=ISO.DATE)
	private LocalDate fechaCreacionUser;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="users_roles",
		joinColumns=@JoinColumn(name="user_id"),
		inverseJoinColumns=@JoinColumn(name="role_id"))
	@JsonIdentityReference(alwaysAsId = true)
	private Set<RolEntity>itemsRole=new HashSet<>();
	
	@OneToOne(mappedBy = "usuario")
	private ClienteEntity cliente;
	
	@OneToOne(mappedBy = "usuario")
	private PersonalEntity personal;
	
	@PrePersist
	public void prePersist() {
		fechaCreacionUser=LocalDate.now();
	}
	
	public UserEntity() {
		super();
	}

	public UserEntity(Integer usuarioID, String email, String password, LocalDate fechaCreacionUser,
			Set<RolEntity> itemsRole, ClienteEntity cliente, PersonalEntity personal) {
		super();
		this.usuarioID = usuarioID;
		this.email = email;
		this.password = password;
		this.fechaCreacionUser = fechaCreacionUser;
		this.itemsRole = itemsRole;
		this.cliente = cliente;
		this.personal = personal;
	}

	public Integer getUsuarioID() {
		return usuarioID;
	}

	public void setUsuarioID(Integer usuarioID) {
		this.usuarioID = usuarioID;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDate getFechaCreacionUser() {
		return fechaCreacionUser;
	}

	public void setFechaCreacionUser(LocalDate fechaCreacionUser) {
		this.fechaCreacionUser = fechaCreacionUser;
	}

	public Set<RolEntity> getItemsRole() {
		return itemsRole;
	}

	public void setItemsRole(Set<RolEntity> itemsRole) {
		this.itemsRole = itemsRole;
	}

	public ClienteEntity getCliente() {
		return cliente;
	}

	public void setCliente(ClienteEntity cliente) {
		this.cliente = cliente;
	}

	public PersonalEntity getPersonal() {
		return personal;
	}

	public void setPersonal(PersonalEntity personal) {
		this.personal = personal;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
