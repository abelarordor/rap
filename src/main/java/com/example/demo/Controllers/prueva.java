package com.example.demo.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.dao.IUsuarioDao;
import com.example.demo.models.entity.Usuario;
import com.example.demo.service.IUsuarioService;
import com.example.demo.service.UsuarioServiceImpl;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/api")
public class prueva {
	@Autowired
	private IUsuarioDao usuarioservice;
	private UsuarioServiceImpl usuarioservice2;
	@GetMapping("/prueva/{id}")
	public Usuario show(@PathVariable Long id){
		return usuarioservice.eventsBySport(id);
	}

}
