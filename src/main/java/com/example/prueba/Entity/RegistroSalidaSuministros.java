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
@Table(name = "Registro_Salida_Suministro")
public class RegistroSalidaSuministros implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer registroSalidaSuministroID;
	@ManyToOne
    @JoinColumn(name = "Id_Personal")
    private PersonalEntity personal;
	@Column(name = "fecha_registro_salida_suministro")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime fechaRegistroSalidaSuministro;
	@ManyToOne
	@JoinColumn(name = "id_Mantenimiento")
	private MantenimientoEntity mantenimiento;
	@PrePersist
    public void prePersist() {
		fechaRegistroSalidaSuministro = LocalDateTime.now();
    }
	
	public RegistroSalidaSuministros() {
		super();
	}

	public RegistroSalidaSuministros(Integer registroSalidaSuministroID, PersonalEntity personal,
			LocalDateTime fechaRegistroSalidaSuministro, MantenimientoEntity mantenimiento) {
		super();
		this.registroSalidaSuministroID = registroSalidaSuministroID;
		this.personal = personal;
		this.fechaRegistroSalidaSuministro = fechaRegistroSalidaSuministro;
		this.mantenimiento = mantenimiento;
	}
	public Integer getRegistroSalidaSuministroID() {
		return registroSalidaSuministroID;
	}
	public void setRegistroSalidaSuministroID(Integer registroSalidaSuministroID) {
		this.registroSalidaSuministroID = registroSalidaSuministroID;
	}
	public PersonalEntity getPersonal() {
		return personal;
	}
	public void setPersonal(PersonalEntity personal) {
		this.personal = personal;
	}
	public LocalDateTime getFechaRegistroSalidaSuministro() {
		return fechaRegistroSalidaSuministro;
	}
	public void setFechaRegistroSalidaSuministro(LocalDateTime fechaRegistroSalidaSuministro) {
		this.fechaRegistroSalidaSuministro = fechaRegistroSalidaSuministro;
	}
	public MantenimientoEntity getMantenimiento() {
		return mantenimiento;
	}
	public void setMantenimiento(MantenimientoEntity mantenimiento) {
		this.mantenimiento = mantenimiento;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}
