package com.prueba.backendSpring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prueba.backendSpring.entities.Proveedor;

@Repository("ProveedorRepository")
public interface ProveedorRepository extends JpaRepository<Proveedor, Long> {

}
