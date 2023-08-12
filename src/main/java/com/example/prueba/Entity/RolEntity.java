package com.example.prueba.Entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@Table(name="Rol")
public class RolEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer rolID;
	@Column(unique=true,nullable = false)
	private String type;
	@JsonBackReference
	@ManyToMany(mappedBy="itemsRole",fetch=FetchType.EAGER)
	private Set<UserEntity> itemsUser=new HashSet<>();
	
	public RolEntity() {
		super();
	}
	public RolEntity(Integer rolID, String type, Set<UserEntity> itemsUser) {
		super();
		this.rolID = rolID;
		this.type = type;
		this.itemsUser = itemsUser;
	}
	public Integer getRolID() {
		return rolID;
	}
	public void setRolID(Integer rolID) {
		this.rolID = rolID;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Set<UserEntity> getItemsUser() {
		return itemsUser;
	}
	public void setItemsUser(Set<UserEntity> itemsUser) {
		this.itemsUser = itemsUser;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}
