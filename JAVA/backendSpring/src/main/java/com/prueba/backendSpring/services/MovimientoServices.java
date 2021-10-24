package com.prueba.backendSpring.services;

import java.sql.Date;
import java.util.List;

import com.prueba.backendSpring.dto.ItemMovimientoDTO;

public interface MovimientoServices {

	public abstract List<ItemMovimientoDTO> obtenerItemMovimiento(Date fecha_inicio, Date fecha_fin, String tipoFiltro, String valorFiltro);
}
