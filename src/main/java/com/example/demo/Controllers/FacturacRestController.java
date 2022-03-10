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

import com.example.demo.models.entity.EncabezadoVenta;
import com.example.demo.service.IfacturacionService;



@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class FacturacRestController {
	@Autowired
	private IfacturacionService factura;
	
	@GetMapping("/facturas")
	public List<EncabezadoVenta> index() {
		return factura.findAll();

}
	@GetMapping("/facturas/{id}")
	public ResponseEntity<?> show(@PathVariable Long id) {
		EncabezadoVenta encabezado=factura.findById(id);
		Map <String, Object> response =new HashMap<>();
		try {
			encabezado=factura.findById(id);
		} catch (Exception e) {
		response.put("mensaje", "Error al realizar consulta");
		return new ResponseEntity<Map<String,Object>>(response, HttpStatus.NOT_FOUND);
		}
		if(encabezado==null) {
			response.put("mnsaje", "El id del servicio ".concat(id.toString().concat(" no existe")));
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.NOT_FOUND);
			
		}
		return new ResponseEntity<EncabezadoVenta>(encabezado,HttpStatus.OK);
	}
	
	
	
	
	
	
	@PostMapping("/facturas")
	@ResponseStatus(HttpStatus.CREATED)
	public EncabezadoVenta create(@RequestBody EncabezadoVenta encabezado) {
		return factura.save(encabezado);
	}
	
	@PutMapping("/facturas/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public 	EncabezadoVenta update(@RequestBody EncabezadoVenta encabezado, @PathVariable Long id) {
		EncabezadoVenta encabezadoactual = factura.findById(id);
		encabezadoactual.setFechaventa(encabezado.getFechaventa());
		encabezadoactual.setUsuario(encabezado.getUsuario());
		
		return factura.save(encabezadoactual);
	}
	
	@DeleteMapping("/facturas/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		
		factura.delete(id);
	}

	
}
