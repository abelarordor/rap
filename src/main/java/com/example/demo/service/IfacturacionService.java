package com.example.demo.service;

import java.util.List;

import com.example.demo.models.entity.EncabezadoVenta;





public interface IfacturacionService {
	
	public List<EncabezadoVenta> findAll();
	public EncabezadoVenta findById(Long id);
	public EncabezadoVenta save(EncabezadoVenta encabezado);
	public void delete(Long id);
}
