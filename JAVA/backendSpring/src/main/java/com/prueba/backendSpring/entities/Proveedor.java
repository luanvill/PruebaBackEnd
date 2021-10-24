package com.prueba.backendSpring.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.prueba.backendSpring.dto.ProveedorDTO;

@Entity
@Table(name = "PROVEEDOR")
public class Proveedor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigo_proveedor")
	private Long codigoProveedor;

	@Column(name = "ruc")
	private String ruc;

	@Column(name = "nombre_proveedor")
	private String nombreProveedor;

	@Column(name = "direccion")
	private String direccion;

	@Column(name = "telefonos")
	private String telefonos;

	@Column(name = "emails")
	private String emails;

	@Column(name = "usuario_registro")
	private String usuarioRegistro;

	@Column(name = "fecha_registro")
	private Date fechaRegistro;

	public Long getCodigoProveedor() {
		return codigoProveedor;
	}

	public void setCodigoProveedor(Long codigoProveedor) {
		this.codigoProveedor = codigoProveedor;
	}

	public String getRuc() {
		return ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	public String getNombreProveedor() {
		return nombreProveedor;
	}

	public void setNombreProveedor(String nombreProveedor) {
		this.nombreProveedor = nombreProveedor;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefonos() {
		return telefonos;
	}

	public void setTelefonos(String telefonos) {
		this.telefonos = telefonos;
	}

	public String getEmails() {
		return emails;
	}

	public void setEmails(String emails) {
		this.emails = emails;
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
