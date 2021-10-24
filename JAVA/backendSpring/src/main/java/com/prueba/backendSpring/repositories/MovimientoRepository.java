package com.prueba.backendSpring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prueba.backendSpring.entities.Movimiento;

public interface MovimientoRepository extends JpaRepository<Movimiento, Long>{

}
