package com.example.demo.Controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
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

import com.example.demo.models.entity.Servicios;

import com.example.demo.service.IServicioService;




@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/api")
public class ServiciosRestController {
	@Autowired
	private IServicioService servicioservice;
	
	@GetMapping("/servicios")
	public List<Servicios> index() {
		return servicioservice.findAll();

}
	@GetMapping("/servicios/{id}")
	public ResponseEntity<?> show(@PathVariable Long id) {
		Servicios servicio= servicioservice.findById(id);
		Map <String, Object> response =new HashMap<>();
		try {
			servicio=servicioservice.findById(id);
		} catch (Exception e) {
		response.put("mensaje", "Error al realizar consulta");
		return new ResponseEntity<Map<String,Object>>(response, HttpStatus.NOT_FOUND);
		}
		if(servicio==null) {
			response.put("mnsaje", "El id del servicio ".concat(id.toString().concat(" no existe")));
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.NOT_FOUND);
			
		}
		return new ResponseEntity<Servicios>(servicio,HttpStatus.OK);
	}
	
	@PostMapping("/servicios")
	@ResponseStatus(HttpStatus.CREATED)
	public Servicios create(@RequestBody Servicios servicio) {
		return servicioservice.save(servicio);
	}
	
	@PutMapping("/servicios/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> update(@Validated @RequestBody Servicios servicio, BindingResult result, @PathVariable Long id) {

		Servicios serviActual = servicioservice.findById(id);

			Servicios serviUpdated = null;

			Map<String, Object> response = new HashMap<>();

			if(result.hasErrors()) {

				List<String> errors = result.getFieldErrors()
						.stream()
						.map(err -> "El campo '" + err.getField() +"' "+ err.getDefaultMessage())
						.collect(Collectors.toList());
				
				response.put("errors", errors);
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
			}
			
			if (serviActual == null) {
				response.put("mensaje", "Error: no se pudo editar, el servicio ID: "
						.concat(id.toString().concat(" no existe en la base de datos!")));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
			}

			try {

				serviActual.setDescripcion(servicio.getDescripcion());
				serviActual.setNombre(servicio.getNombre());
				serviActual.setPrecio(servicio.getPrecio());

				 serviUpdated = servicioservice.save(serviActual);

			} catch (DataAccessException e) {
				response.put("mensaje", "Error al actualizar el Servicio en la base de datos");
				response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}

			response.put("mensaje", "El servicio ha sido actualizado con éxito!");
			response.put("cliente", serviActual);

			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
		}
	
	@DeleteMapping("/servicios/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		
		servicioservice.delete(id);
	}

}
