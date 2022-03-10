package com.example.demo.service;

import java.util.List;

import com.example.demo.models.entity.Servicios;




public interface IServicioService {
	public List<Servicios> findAll();
	public Servicios findById(Long id);
	public Servicios save(Servicios usuario);
	public void delete(Long id);
}
