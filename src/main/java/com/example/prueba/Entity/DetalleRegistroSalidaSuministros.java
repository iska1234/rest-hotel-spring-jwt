package com.example.prueba.Entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="DetalleSalidaSuministros")
public class DetalleRegistroSalidaSuministros implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "salida_id", nullable = false)
    private RegistroSalidaSuministros salida;

    @ManyToOne
    @JoinColumn(name = "suministro_id", nullable = false)
    private SuministroEntity suministro;

    @Column(name = "cantidad")
    private Integer cantidadSalida;
    

	public DetalleRegistroSalidaSuministros() {
		super();
	}

	public DetalleRegistroSalidaSuministros(Integer id, RegistroSalidaSuministros salida, SuministroEntity suministro,
			Integer cantidadSalida) {
		super();
		this.id = id;
		this.salida = salida;
		this.suministro = suministro;
		this.cantidadSalida = cantidadSalida;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public RegistroSalidaSuministros getSalida() {
		return salida;
	}

	public void setSalida(RegistroSalidaSuministros salida) {
		this.salida = salida;
	}

	public SuministroEntity getSuministro() {
		return suministro;
	}

	public void setSuministro(SuministroEntity suministro) {
		this.suministro = suministro;
	}

	public Integer getCantidadSalida() {
		return cantidadSalida;
	}

	public void setCantidadSalida(Integer cantidadSalida) {
		this.cantidadSalida = cantidadSalida;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    

}
