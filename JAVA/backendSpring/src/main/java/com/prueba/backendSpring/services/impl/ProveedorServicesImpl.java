package com.prueba.backendSpring.services.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.backendSpring.dto.ProveedorDTO;
import com.prueba.backendSpring.entities.Proveedor;
import com.prueba.backendSpring.repositories.ProveedorRepository;
import com.prueba.backendSpring.services.ProveedorServices;

@Service("ProveedorServices")
public class ProveedorServicesImpl implements ProveedorServices {
	
	@Autowired
	private ProveedorRepository proveedorRepository;

	@Override
	public Long insertarProveedor(ProveedorDTO p) {
		Long codigoProveedor = (long) -1;
		Proveedor proveedor = new Proveedor();
		
		//proveedor.setCodigoProveedor(p.getCodigoProveedor());
		proveedor.setRuc(p.getRuc());
		proveedor.setNombreProveedor(p.getNombreProveedor());
		proveedor.setDireccion(p.getDireccion());
		proveedor.setTelefonos(p.getTelefonos());
		proveedor.setEmails(p.getEmails());
		proveedor.setUsuarioRegistro(p.getUsuarioRegistro());
		proveedor.setFechaRegistro(p.getFechaRegistro());
		
		Proveedor resp = this.proveedorRepository.save(proveedor);
		codigoProveedor = resp.getCodigoProveedor();
		
		return codigoProveedor;
	}

}
