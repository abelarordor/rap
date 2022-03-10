package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.models.dao.IServiciosDao;
import com.example.demo.models.entity.Servicios;



@Service
public class ServiciosServiceImpl implements IServicioService {
	@Autowired
	private IServiciosDao serviciosdao;
	@Override
	@Transactional(readOnly = true)
	public List<Servicios> findAll() {
		
		return (List<Servicios>) serviciosdao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Servicios findById(Long id) {

		return serviciosdao.findById(id).orElse(null);
	}
	

	

	
	@Override
	@Transactional
	public void delete(Long id) {
		serviciosdao.deleteById(id);
		
	}

	@Override
	@Transactional
	public Servicios save(Servicios usuario) {
		return serviciosdao.save(usuario);
	}

}
