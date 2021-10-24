package com.prueba.backendSpring.services;

import org.springframework.stereotype.Service;

import com.prueba.backendSpring.dto.ProveedorDTO;

@Service
public interface ProveedorServices {
	
	public abstract Long insertarProveedor(ProveedorDTO data);

}
