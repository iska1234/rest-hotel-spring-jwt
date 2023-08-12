package com.example.prueba.Entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name="PlanillaTrabajador")
public class PlanillaTrabajadorEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer planillaPersonalID;
	@Column
	private String tipoTrabajador;
	@Column(name = "monto", precision = 6, scale = 2)
    private BigDecimal monto;
	@OneToOne
    @JoinColumn(name = "personalID")
    private PersonalEntity personal;
	
	public PlanillaTrabajadorEntity() {
		super();
	}
	public PlanillaTrabajadorEntity(Integer planillaPersonalID, String tipoTrabajador, BigDecimal monto,
			PersonalEntity personal) {
		super();
		this.planillaPersonalID = planillaPersonalID;
		this.tipoTrabajador = tipoTrabajador;
		this.monto = monto;
		this.personal = personal;
	}
	public Integer getPlanillaPersonalID() {
		return planillaPersonalID;
	}
	public void setPlanillaPersonalID(Integer planillaPersonalID) {
		this.planillaPersonalID = planillaPersonalID;
	}
	public String getTipoTrabajador() {
		return tipoTrabajador;
	}
	public void setTipoTrabajador(String tipoTrabajador) {
		this.tipoTrabajador = tipoTrabajador;
	}
	public BigDecimal getMonto() {
		return monto;
	}
	public void setMonto(BigDecimal monto) {
		this.monto = monto;
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
