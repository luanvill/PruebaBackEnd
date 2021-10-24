package com.prueba.backendSpring.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MOVIMIENTO")
public class Movimiento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SECUENCIA")
	private Long secuencia;

	@Column(name = "CODIGO_ITEM")
	private String codigoItem;

	@Column(name = "CODIGO_PROVEEDOR")
	private String codigoProveedor;

	@Column(name = "FECHA_HORA_MOVIMIENTO")
	private Date fechaHoraMovimiento;

	@Column(name = "PRECIO")
	private double precio;

	@Column(name = "CODIGO_BODEGA")
	private Long codigoBodega;

	@Column(name = "ESTADO")
	private String estado;

	@Column(name = "USUARIO_REGISTRO")
	private String usuarioRegistro;

	@Column(name = "FECHA_REGISTRO")
	private Date fechaRegistro;

	public Long getSecuencia() {
		return secuencia;
	}

	public void setSecuencia(Long secuencia) {
		this.secuencia = secuencia;
	}

	public String getCodigoItem() {
		return codigoItem;
	}

	public void setCodigoItem(String codigoItem) {
		this.codigoItem = codigoItem;
	}

	public String getCodigoProveedor() {
		return codigoProveedor;
	}

	public void setCodigoProveedor(String codigoProveedor) {
		this.codigoProveedor = codigoProveedor;
	}

	public Date getFechaHoraMovimiento() {
		return fechaHoraMovimiento;
	}

	public void setFechaHoraMovimiento(Date fechaHoraMovimiento) {
		this.fechaHoraMovimiento = fechaHoraMovimiento;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public Long getCodigoBodega() {
		return codigoBodega;
	}

	public void setCodigoBodega(Long codigoBodega) {
		this.codigoBodega = codigoBodega;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getUsuarioRegistro() {
		return usuarioRegistro;
	}

	public void setUsuarioRegistro(String usuarioRegistro) {
		this.usuarioRegistro = usuarioRegistro;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

}
