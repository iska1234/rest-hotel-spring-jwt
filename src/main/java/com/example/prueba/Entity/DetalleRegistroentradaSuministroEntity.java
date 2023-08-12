package com.example.prueba.Entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="Detalles_Entrada_Suministro")
public class DetalleRegistroentradaSuministroEntity implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "entrada_id", nullable = false)
    private RegistroEntradaSuministroEntity entrada;

    @ManyToOne
    @JoinColumn(name = "suministro_id", nullable = false)
    private SuministroEntity suministro;

    @Column(name = "cantidad_recibida")
    private Integer cantidadRecibida;

    @Column(name = "precio_unitario", precision = 6, scale = 2)
    private BigDecimal precioUnitario;

    @Column(name = "subtotal", precision = 6, scale = 2)
    private BigDecimal subtotal;
    
    @Column(name = "total", precision = 6, scale = 2)
    private BigDecimal total;
    

	public DetalleRegistroentradaSuministroEntity() {
		super();
	}

	public DetalleRegistroentradaSuministroEntity(Integer id, RegistroEntradaSuministroEntity entrada,
			SuministroEntity suministro, Integer cantidadRecibida, BigDecimal precioUnitario, BigDecimal subtotal,
			BigDecimal total) {
		super();
		this.id = id;
		this.entrada = entrada;
		this.suministro = suministro;
		this.cantidadRecibida = cantidadRecibida;
		this.precioUnitario = precioUnitario;
		this.subtotal = subtotal;
		this.total = total;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public RegistroEntradaSuministroEntity getEntrada() {
		return entrada;
	}

	public void setEntrada(RegistroEntradaSuministroEntity entrada) {
		this.entrada = entrada;
	}

	public SuministroEntity getSuministro() {
		return suministro;
	}

	public void setSuministro(SuministroEntity suministro) {
		this.suministro = suministro;
	}

	public Integer getCantidadRecibida() {
		return cantidadRecibida;
	}

	public void setCantidadRecibida(Integer cantidadRecibida) {
		this.cantidadRecibida = cantidadRecibida;
	}

	public BigDecimal getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(BigDecimal precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public BigDecimal getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    

}
