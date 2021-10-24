package com.prueba.backendSpring.controllers;

import java.sql.Date;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;

import javax.persistence.EntityManager;
import javax.persistence.Tuple;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.backendSpring.dto.ProveedorDTO;
import com.prueba.backendSpring.dto.ItemMovimientoDTO;
import com.prueba.backendSpring.services.MovimientoServices;
import com.prueba.backendSpring.services.ProveedorServices;


@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
@RestController
@RequestMapping("/")
public class ApiControllers {

	@Autowired
	private ProveedorServices proveedorServices;
	@Autowired
	private MovimientoServices movimientoServices;

	@PostMapping("/proveedor")
	public ResponseEntity<?> setProveedor(@RequestBody ProveedorDTO proveedor) {
		ResponseEntity<?> response = null;
		LinkedHashMap<String, Object> resp = new LinkedHashMap<>();
		LinkedHashMap<String, Object> data = new LinkedHashMap<>();
		if(Objects.isNull(proveedor.getNombreProveedor()) ) {
			resp.put("code", 400);
			resp.put("success", false);
			resp.put("message", "El campo nombre_proveedor no es valido");
			resp.put("errorData", new ArrayList<>());
			response = new ResponseEntity<>(resp, HttpStatus.BAD_REQUEST);
			return response;
		}
		/*if(Objects.isNull(proveedor.getCodigoProveedor())) {
			resp.put("code", 400);
			resp.put("success", false);
			resp.put("message", "El campo codigo_proveedor no es valido");
			resp.put("errorData", new ArrayList<>());
			response = new ResponseEntity<>(resp, HttpStatus.BAD_REQUEST);
			return response;
		}*/
		if(Objects.isNull(proveedor.getDireccion())) {
			resp.put("code", 400);
			resp.put("success", false);
			resp.put("message", "El campo direccion no es valido");
			resp.put("errorData", new ArrayList<>());
			response = new ResponseEntity<>(resp, HttpStatus.BAD_REQUEST);
			return response;
		}
		if(Objects.isNull(proveedor.getTelefonos())) {
			resp.put("code", 400);
			resp.put("success", false);
			resp.put("message", "El campo telefonos no es valido");
			resp.put("errorData", new ArrayList<>());
			response = new ResponseEntity<>(resp, HttpStatus.BAD_REQUEST);
			return response;
		}
		if(Objects.isNull(proveedor.getEmails())) {
			resp.put("code", 400);
			resp.put("success", false);
			resp.put("message", "El campo emails no es valido");
			resp.put("errorData", new ArrayList<>());
			response = new ResponseEntity<>(resp, HttpStatus.BAD_REQUEST);
			return response;
		}
		if(Objects.isNull(proveedor.getEmails())) {
			resp.put("code", 400);
			resp.put("success", false);
			resp.put("message", "El campo emails no es valido");
			resp.put("errorData", new ArrayList<>());
			response = new ResponseEntity<>(resp, HttpStatus.BAD_REQUEST);
			return response;
		}
		
		if(Objects.isNull(proveedor.getUsuarioRegistro())) {
			resp.put("code", 400);
			resp.put("success", false);
			resp.put("message", "El campo usuario_registro no es valido");
			resp.put("errorData", new ArrayList<>());
			response = new ResponseEntity<>(resp, HttpStatus.BAD_REQUEST);
			return response;
		}
		if(Objects.isNull(proveedor.getFechaRegistro())) {
			resp.put("code", 400);
			resp.put("success", false);
			resp.put("message", "El campo fecha_registro no es valido");
			resp.put("errorData", new ArrayList<>());
			response = new ResponseEntity<>(resp, HttpStatus.BAD_REQUEST);
			return response;
		}
		
		Long codigoProveedor = proveedorServices.insertarProveedor(proveedor);
		try {
			if (codigoProveedor != -1) {
				data.put("codigoProveedor", codigoProveedor);
				resp.put("code", 200);
				resp.put("success", true);
				resp.put("message", "OK");
				resp.put("data", data);
				response = new ResponseEntity<>(resp, HttpStatus.OK);
				return response;
			} else {
				resp.put("code", 400);
				resp.put("success", false);
				resp.put("message", "El campo codigo_proveedor no es valido");
				resp.put("errorData", new ArrayList<>());
				response = new ResponseEntity<>(resp, HttpStatus.BAD_REQUEST);
				return response;
			}
			
		} catch (Exception e) {
			resp.put("code", 500);
			resp.put("success", false);
			resp.put("message", "Ha ocurrido un error inesperado");
			resp.put("errorData", e);
			return new ResponseEntity<>(resp, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/item_movimiento")
	public ResponseEntity<?> getItemMovimiento(@RequestParam(name = "fecha_inicio", required = true) Date fecha_inicio,
												@RequestParam(name = "fecha_fin", required = true) Date fecha_fin,
												@RequestParam(name = "tipoFiltro", required = false) String tipoFiltro,
												@RequestParam(name = "valorFiltro", required = false) String valorFiltro) {
		
		LinkedHashMap<String, Object> resp = new LinkedHashMap<>();
        try {
            if(Objects.isNull(fecha_inicio) || Objects.isNull(fecha_fin)) {
            	resp.put("code", 400);
                resp.put("succes",false);
                resp.put("message", "Fecha de inicio y fin son requeridas.");
                resp.put("data", new ArrayList());
                return new ResponseEntity<>(resp, HttpStatus.BAD_REQUEST);
            }
            if(!Objects.isNull(valorFiltro) && Objects.isNull(tipoFiltro)) {
            	resp.put("code", 400);
                resp.put("succes",false);
                resp.put("message", "Tipo filtro requerido");
                resp.put("data", new ArrayList());
                return new ResponseEntity<>(resp, HttpStatus.BAD_REQUEST);
            }
            
            List<ItemMovimientoDTO> lista = this.movimientoServices.obtenerItemMovimiento(fecha_inicio, fecha_fin, tipoFiltro, valorFiltro);
            
            resp.put("code", 200);
            resp.put("succes",true);
            resp.put("message", "OK");
            resp.put("data",lista);
            return new ResponseEntity<>(resp, HttpStatus.OK);
            
        } catch (Exception e) {
            resp.put("code", 500);
            resp.put("message", "Ha ocurrido un error inesperado");
            resp.put("errorData", e );
            return new ResponseEntity<>(resp, HttpStatus.INTERNAL_SERVER_ERROR);
        }
	}

}
