package com.prueba.backendSpring.services.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.EntityManager;
import javax.persistence.Tuple;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.backendSpring.dto.ItemMovimientoDTO;
import com.prueba.backendSpring.services.MovimientoServices;

@Service("MovimientoServices")
public class MovimientoServicesImpl implements MovimientoServices{
	
	@Autowired
    EntityManager em;

	@Override
	public List<ItemMovimientoDTO> obtenerItemMovimiento(Date fecha_inicio, Date fecha_fin, String tipoFiltro,
			String valorFiltro) {
		StringBuilder sb = new StringBuilder();
        sb.append("SELECT movimiento.secuencia, item.descripcion_item, bodega.nombre_bodega, ");
        sb.append("proveedor.nombre_proveedor, movimiento.fecha_hora_movimiento, movimiento.tipo_movimiento, ");
        sb.append("movimiento.cantidad FROM  MOVIMIENTO INNER JOIN ITEM ON MOVIMIENTO.codigo_item = ITEM.codigo_item ");
        sb.append("INNER JOIN PROVEEDOR ON PROVEEDOR.codigo_proveedor = MOVIMIENTO.codigo_proveedor ");
        sb.append("INNER JOIN BODEGA ON BODEGA.codigo_bodega = ITEM.codigo_bodega ");
        sb.append("WHERE movimiento.fecha_hora_movimiento BETWEEN :fecha_inicio AND :fecha_fin ");
        
        if(!Objects.isNull(valorFiltro) && !Objects.isNull(tipoFiltro)) {
        	if(tipoFiltro.equalsIgnoreCase("codigo_item")) {
        		sb.append("AND item.codigo_item = :valorFiltro");
        	}else if(tipoFiltro.equalsIgnoreCase("nombre_item")) {
        		sb.append("AND item.descripcion_item = :valorFiltro");
        	}
        }
        
        
        TypedQuery<Tuple> query = (TypedQuery<Tuple>) em.createNativeQuery(sb.toString(), Tuple.class);
        
        query.setParameter("fecha_inicio", fecha_inicio);
        query.setParameter("fecha_fin", fecha_fin);
        
        if(!Objects.isNull(valorFiltro) && !Objects.isNull(tipoFiltro)) {
        	query.setParameter("valorFiltro", valorFiltro);
        }
        
        List<Tuple> lsResult = query.getResultList();
        List<ItemMovimientoDTO> itemMovimientos = new ArrayList<>();
        
        for(Tuple tuple: lsResult){
        	ItemMovimientoDTO itemMovimiento = new ItemMovimientoDTO();
        	
        	itemMovimiento.setSecuencia(tuple.get("secuencia",Long.class));
        	itemMovimiento.setDescripcion_item(tuple.get("descripcion_item",String.class));
        	itemMovimiento.setNombreBodega(tuple.get("nombreBodega",String.class));
        	itemMovimiento.setNombreProveedor(tuple.get("nombreProveedor",String.class));
        	itemMovimiento.setFecha_hora_movimiento(tuple.get("fecha_hora_movimiento",Date.class));
        	itemMovimiento.setDescripcion_tipo_movimiento(tuple.get("tipo_movimiento",String.class));
        	itemMovimiento.setCantidad(tuple.get("cantidad",Integer.class));
        	
        	itemMovimientos.add(itemMovimiento);
        }
		return itemMovimientos;
	}

}
