package com.example.prueba.Entity;

import java.io.Serializable;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;




@Entity
@Table(name="RegistroEntradaSuministros")
public class RegistroEntradaSuministroEntity implements Serializable  {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer registroEntradaID;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime fechaEntradaSuministro;
	
	@Column(name = "numero_factura")
	private String factura;
	
	@ManyToOne
    @JoinColumn(name = "Id_Personal")
    private PersonalEntity personal;
	
	@ManyToOne
	@JoinColumn(name = "Id_Proveedores")
	private ProveedoresEntity proveedores;
	
	@PrePersist
	public void prePersist() {
		fechaEntradaSuministro=LocalDateTime.now();
	}
	

	public RegistroEntradaSuministroEntity() {
		super();
	}


	public RegistroEntradaSuministroEntity(Integer registroEntradaID, LocalDateTime fechaEntradaSuministro,
			String factura, PersonalEntity personal, ProveedoresEntity proveedores) {
		super();
		this.registroEntradaID = registroEntradaID;
		this.fechaEntradaSuministro = fechaEntradaSuministro;
		this.factura = factura;
		this.personal = personal;
		this.proveedores = proveedores;
	}

	public Integer getRegistroEntradaID() {
		return registroEntradaID;
	}

	public void setRegistroEntradaID(Integer registroEntradaID) {
		this.registroEntradaID = registroEntradaID;
	}

	public LocalDateTime getFechaEntradaSuministro() {
		return fechaEntradaSuministro;
	}

	public void setFechaEntradaSuministro(LocalDateTime fechaEntradaSuministro) {
		this.fechaEntradaSuministro = fechaEntradaSuministro;
	}

	public String getFactura() {
		return factura;
	}

	public void setFactura(String factura) {
		this.factura = factura;
	}

	public PersonalEntity getPersonal() {
		return personal;
	}

	public void setPersonal(PersonalEntity personal) {
		this.personal = personal;
	}

	public ProveedoresEntity getProveedores() {
		return proveedores;
	}

	public void setProveedores(ProveedoresEntity proveedores) {
		this.proveedores = proveedores;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
