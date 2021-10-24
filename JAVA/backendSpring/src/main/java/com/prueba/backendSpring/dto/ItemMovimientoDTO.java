package com.prueba.backendSpring.dto;

import java.sql.Date;

public class ItemMovimientoDTO {
	
	private Long secuencia;
	
	private String descripcion_item;
	
	private String nombreBodega;
	
	private String nombreProveedor;
	
	private Date fecha_hora_movimiento;
	
	private String descripcion_tipo_movimiento;
	
	private int cantidad;

	public Long getSecuencia() {
		return secuencia;
	}

	public void setSecuencia(Long secuencia) {
		this.secuencia = secuencia;
	}

	public String getNombreBodega() {
		return nombreBodega;
	}

	public void setNombreBodega(String nombreBodega) {
		this.nombreBodega = nombreBodega;
	}

	public String getNombreProveedor() {
		return nombreProveedor;
	}

	public void setNombreProveedor(String nombreProveedor) {
		this.nombreProveedor = nombreProveedor;
	}

	public String getDescripcion_item() {
		return descripcion_item;
	}

	public void setDescripcion_item(String descripcion_item) {
		this.descripcion_item = descripcion_item;
	}

	public Date getFecha_hora_movimiento() {
		return fecha_hora_movimiento;
	}

	public void setFecha_hora_movimiento(Date fecha_hora_movimiento) {
		this.fecha_hora_movimiento = fecha_hora_movimiento;
	}

	public String getDescripcion_tipo_movimiento() {
		return descripcion_tipo_movimiento;
	}

	public void setDescripcion_tipo_movimiento(String descripcion_tipo_movimiento) {
		this.descripcion_tipo_movimiento = descripcion_tipo_movimiento;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	
	

}