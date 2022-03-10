package com.example.demo.Controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.entity.DetalleVenta;
import com.example.demo.service.detalleimplementacion;



@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class DetalleRestController {

	@Autowired
	private detalleimplementacion detalleventa;
	@GetMapping("/facturasdetalle")
	public List<DetalleVenta> index() {
		return detalleventa.findAll();
	}
	
	@GetMapping("/facturasdetalle/{id}")
	public ResponseEntity<?> show(@PathVariable Long id) {
		DetalleVenta detalle=detalleventa.findById(id);
		Map <String, Object> response =new HashMap<>();
		try {
			detalle=detalleventa.findById(id);
		} catch (Exception e) {
		response.put("mensaje", "Error al realizar consulta");
		return new ResponseEntity<Map<String,Object>>(response, HttpStatus.NOT_FOUND);
		}
		if(detalle==null) {
			response.put("mnsaje", "El id del servicio ".concat(id.toString().concat(" no existe")));
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.NOT_FOUND);
			
		}
		return new ResponseEntity<DetalleVenta>(detalle,HttpStatus.OK);
	}
	
	
	@PostMapping("/facturasdetalle")
	@ResponseStatus(HttpStatus.CREATED)
	public DetalleVenta create(@RequestBody DetalleVenta detalle) {
		int cantidad;
		cantidad=detalle.getCantidad();
		detalle.getCantidadagua();
		detalle.setPreciounidad(cantidad);
		return detalleventa.save(detalle);
	}
	
	@PutMapping("/facturasdetalle/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public 	DetalleVenta update(@RequestBody DetalleVenta detalle, @PathVariable Long id) {
		DetalleVenta detalleactual = detalleventa.findById(id);
		detalleactual.setCantidad(detalle.getCantidad());
		detalleactual.setCantidadagua(detalle.getCantidadagua());
		detalleactual.setNumlugares(detalle.getNumlugares());
		detalleactual.setPreciounidad(detalle.getPreciounidad());
		
		
		return detalleventa.save(detalleactual);
	}
	
	@DeleteMapping("/facturasdetalle/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		
		detalleventa.delete(id);
	}
	
	
	
	
}
