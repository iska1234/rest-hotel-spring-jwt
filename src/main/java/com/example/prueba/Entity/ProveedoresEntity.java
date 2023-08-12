package com.example.prueba.Entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

@Entity
@Table(name="Proveedores")
public class ProveedoresEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer proveedorID;
	
	@Column(name = "nombre_empresa")
	private String nombreEmpresa;
	
	@Column(name = "nombre_encargado")
	private String nombreEncargado;
	
	@Column(name = "apellidos_encargado")
	private String apellidosEncargado;
	
	@Column(name = "email_empresa")
	private String emailEmpresa;
	
	@Column(name = "telefono_empresa")
	private String telefonoEmpresa;
	
	@Column(name = "telefono_encargado")
	private String telefono;
	
	@Column(name = "RUC")
	private String ruc;
	
	@Column(name = "direccion_empresa")
	private String direccion;
	
	@Column(nullable = false)
    private boolean estado = true;
	@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "suministro_proveedor",
        joinColumns = @JoinColumn(name = "proveedor_id"),
        inverseJoinColumns = @JoinColumn(name = "suministro_id")
    )
    private List<SuministroEntity> suministros = new ArrayList<>();
	
	public ProveedoresEntity() {
		super();
	}
	public ProveedoresEntity(Integer proveedorID, String nombreEmpresa, String nombreEncargado,
			String apellidosEncargado, String emailEmpresa, String telefonoEmpresa, String telefono, String ruc,
			String direccion, boolean estado, List<SuministroEntity> suministros) {
		super();
		this.proveedorID = proveedorID;
		this.nombreEmpresa = nombreEmpresa;
		this.nombreEncargado = nombreEncargado;
		this.apellidosEncargado = apellidosEncargado;
		this.emailEmpresa = emailEmpresa;
		this.telefonoEmpresa = telefonoEmpresa;
		this.telefono = telefono;
		this.ruc = ruc;
		this.direccion = direccion;
		this.estado = estado;
		this.suministros = suministros;
	}
	public Integer getProveedorID() {
		return proveedorID;
	}
	public void setProveedorID(Integer proveedorID) {
		this.proveedorID = proveedorID;
	}
	public String getNombreEmpresa() {
		return nombreEmpresa;
	}
	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}
	public String getNombreEncargado() {
		return nombreEncargado;
	}
	public void setNombreEncargado(String nombreEncargado) {
		this.nombreEncargado = nombreEncargado;
	}
	public String getApellidosEncargado() {
		return apellidosEncargado;
	}
	public void setApellidosEncargado(String apellidosEncargado) {
		this.apellidosEncargado = apellidosEncargado;
	}
	public String getEmailEmpresa() {
		return emailEmpresa;
	}
	public void setEmailEmpresa(String emailEmpresa) {
		this.emailEmpresa = emailEmpresa;
	}
	public String getTelefonoEmpresa() {
		return telefonoEmpresa;
	}
	public void setTelefonoEmpresa(String telefonoEmpresa) {
		this.telefonoEmpresa = telefonoEmpresa;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getRuc() {
		return ruc;
	}
	public void setRuc(String ruc) {
		this.ruc = ruc;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	public List<SuministroEntity> getSuministros() {
		return suministros;
	}
	public void setSuministros(List<SuministroEntity> suministros) {
		this.suministros = suministros;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}
