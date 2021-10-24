package com.prueba.backendSpring.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ITEM")
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CODIGO_ITEM")
	private Long codigoItem;

	@Column(name = "GRUPO")
	private String grupo;

	@Column(name = "SUBGRUPO")
	private String subgrupo;

	@Column(name = "STOCK")
	private int stock;

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

	public Long getCodigoItem() {
		return codigoItem;
	}

	public void setCodigoItem(Long codigoItem) {
		this.codigoItem = codigoItem;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public String getSubgrupo() {
		return subgrupo;
	}

	public void setSubgrupo(String subgrupo) {
		this.subgrupo = subgrupo;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
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
